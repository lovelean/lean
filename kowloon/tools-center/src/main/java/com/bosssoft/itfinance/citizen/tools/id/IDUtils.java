package com.bosssoft.itfinance.citizen.tools.id;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.id.IDUtils　　<br/>
 * Description：42位的时间前缀+10位的节点标识+12位的sequence避免并发的数字（12位不够用时强制得到新的时间前缀）
 * 对系统时间的依赖性非常强，需要关闭ntp的时间同步功能，或者当检测到ntp时间调整后，拒绝分配id<br/>
 * Date：2018年10月24日 上午9:23:52<br/>
 * @author lean
 * @version 1.0
 */
public class IDUtils {

    private final static Logger logger = LoggerFactory.getLogger(IDUtils.class);

    private final long workerId;
    private final long snsEpoch = 1330328109047L;// 起始标记点，作为基准
    private long sequence = 0L;// 0，并发控制
    private final long workerIdBits = 10L;// 只允许workid的范围为：0-1023
    private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;// 1023,1111111111,10位
    private final long sequenceBits = 12L;// sequence值控制在0-4095

    private final long workerIdShift = this.sequenceBits;// 12
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;// 22
    private final long sequenceMask = -1L ^ -1L << this.sequenceBits;// 4095,111111111111,12位

    private long lastTimestamp = -1L;

    private static IDUtils IDUtils;

    private IDUtils(long workerId) {
        super();
        if (workerId > this.maxWorkerId || workerId < 0) {// workid < 1024[10位：2的10次方]
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
        this.workerId = workerId;
    }

    private synchronized long nextId() throws Exception {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {// 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环)，下次再使用时sequence是新值
            //System.out.println("lastTimeStamp:" + lastTimestamp);
            this.sequence = this.sequence + 1 & this.sequenceMask;
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);// 重新生成timestamp
            }
        }
        else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            logger.error(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
            throw new Exception(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        // 生成的timestamp
        return timestamp - this.snsEpoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
    }

    /**
     * 
     * Description：保证返回的毫秒数在参数之后 <br/>
     * Date：2018年10月24日 上午9:24:15　<br/>
     * Author：lean <br/>
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * 
     * Description：获得系统当前毫秒数 <br/>
     * Date：2018年10月24日 上午9:24:23　<br/>
     * Author：lean <br/>
     * @return
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 
     * Description：生成唯一18位数字ID <br/>
     * Date：2018年10月24日 上午9:24:28　<br/>
     * Author：lean <br/>
     * @return
     */
    public static String newID(){
        if (IDUtils ==null){
            IDUtils = new IDUtils(1);
        }
        try {
            return String.valueOf(IDUtils.nextId());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * Description：生成GUID，32位 <br/>
     * Date：2018年10月24日 上午9:24:35　<br/>
     * Author：lean <br/>
     * @return
     */
    public static String newGUID() {
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String guid = uuid.toString();
        // 转换为大写
        guid = guid.toUpperCase();
        return guid.replaceAll("-", "");
    }
}



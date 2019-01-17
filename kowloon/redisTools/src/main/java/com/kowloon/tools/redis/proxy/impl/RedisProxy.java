
/**   
 * Title：RedisTemplate.java 　<br/>
 * Package：com.kowloon.tools.redis.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:37:21<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.proxy.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kowloon.tools.redis.proxy.IRedisProxy;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.BitPosParams;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

/**
 * 
 * ClassName：com.kowloon.tools.redis.proxy.impl.RedisProxy　　<br/>
 * Description：Redis代理模版实现 <br/>
 * Date：2019年1月17日 下午2:46:14<br/>
 * @author lean
 * @version 1.0
 */
public class RedisProxy implements IRedisProxy {

	/*    
	 * @see redis.clients.jedis.JedisCommands#set(java.lang.String, java.lang.String)   
	 */
	@Override
	public String set(String key, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#set(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)   
	 */
	@Override
	public String set(String key, String value, String nxxx, String expx, long time) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#set(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public String set(String key, String value, String nxxx) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#get(java.lang.String)   
	 */
	@Override
	public String get(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#exists(java.lang.String)   
	 */
	@Override
	public Boolean exists(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#persist(java.lang.String)   
	 */
	@Override
	public Long persist(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#type(java.lang.String)   
	 */
	@Override
	public String type(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#expire(java.lang.String, int)   
	 */
	@Override
	public Long expire(String key, int seconds) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#pexpire(java.lang.String, long)   
	 */
	@Override
	public Long pexpire(String key, long milliseconds) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#expireAt(java.lang.String, long)   
	 */
	@Override
	public Long expireAt(String key, long unixTime) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#pexpireAt(java.lang.String, long)   
	 */
	@Override
	public Long pexpireAt(String key, long millisecondsTimestamp) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#ttl(java.lang.String)   
	 */
	@Override
	public Long ttl(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#pttl(java.lang.String)   
	 */
	@Override
	public Long pttl(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#setbit(java.lang.String, long, boolean)   
	 */
	@Override
	public Boolean setbit(String key, long offset, boolean value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#setbit(java.lang.String, long, java.lang.String)   
	 */
	@Override
	public Boolean setbit(String key, long offset, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#getbit(java.lang.String, long)   
	 */
	@Override
	public Boolean getbit(String key, long offset) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#setrange(java.lang.String, long, java.lang.String)   
	 */
	@Override
	public Long setrange(String key, long offset, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#getrange(java.lang.String, long, long)   
	 */
	@Override
	public String getrange(String key, long startOffset, long endOffset) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#getSet(java.lang.String, java.lang.String)   
	 */
	@Override
	public String getSet(String key, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#setnx(java.lang.String, java.lang.String)   
	 */
	@Override
	public Long setnx(String key, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#setex(java.lang.String, int, java.lang.String)   
	 */
	@Override
	public String setex(String key, int seconds, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#psetex(java.lang.String, long, java.lang.String)   
	 */
	@Override
	public String psetex(String key, long milliseconds, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#decrBy(java.lang.String, long)   
	 */
	@Override
	public Long decrBy(String key, long integer) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#decr(java.lang.String)   
	 */
	@Override
	public Long decr(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#incrBy(java.lang.String, long)   
	 */
	@Override
	public Long incrBy(String key, long integer) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#incrByFloat(java.lang.String, double)   
	 */
	@Override
	public Double incrByFloat(String key, double value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#incr(java.lang.String)   
	 */
	@Override
	public Long incr(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#append(java.lang.String, java.lang.String)   
	 */
	@Override
	public Long append(String key, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#substr(java.lang.String, int, int)   
	 */
	@Override
	public String substr(String key, int start, int end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hset(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long hset(String key, String field, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hget(java.lang.String, java.lang.String)   
	 */
	@Override
	public String hget(String key, String field) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hsetnx(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long hsetnx(String key, String field, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hmset(java.lang.String, java.util.Map)   
	 */
	@Override
	public String hmset(String key, Map<String, String> hash) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hmget(java.lang.String, java.lang.String[])   
	 */
	@Override
	public List<String> hmget(String key, String... fields) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hincrBy(java.lang.String, java.lang.String, long)   
	 */
	@Override
	public Long hincrBy(String key, String field, long value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hincrByFloat(java.lang.String, java.lang.String, double)   
	 */
	@Override
	public Double hincrByFloat(String key, String field, double value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hexists(java.lang.String, java.lang.String)   
	 */
	@Override
	public Boolean hexists(String key, String field) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hdel(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long hdel(String key, String... field) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hlen(java.lang.String)   
	 */
	@Override
	public Long hlen(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hkeys(java.lang.String)   
	 */
	@Override
	public Set<String> hkeys(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hvals(java.lang.String)   
	 */
	@Override
	public List<String> hvals(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hgetAll(java.lang.String)   
	 */
	@Override
	public Map<String, String> hgetAll(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#rpush(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long rpush(String key, String... string) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lpush(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long lpush(String key, String... string) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#llen(java.lang.String)   
	 */
	@Override
	public Long llen(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lrange(java.lang.String, long, long)   
	 */
	@Override
	public List<String> lrange(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#ltrim(java.lang.String, long, long)   
	 */
	@Override
	public String ltrim(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lindex(java.lang.String, long)   
	 */
	@Override
	public String lindex(String key, long index) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lset(java.lang.String, long, java.lang.String)   
	 */
	@Override
	public String lset(String key, long index, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lrem(java.lang.String, long, java.lang.String)   
	 */
	@Override
	public Long lrem(String key, long count, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lpop(java.lang.String)   
	 */
	@Override
	public String lpop(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#rpop(java.lang.String)   
	 */
	@Override
	public String rpop(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sadd(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long sadd(String key, String... member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#smembers(java.lang.String)   
	 */
	@Override
	public Set<String> smembers(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#srem(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long srem(String key, String... member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#spop(java.lang.String)   
	 */
	@Override
	public String spop(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#spop(java.lang.String, long)   
	 */
	@Override
	public Set<String> spop(String key, long count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#scard(java.lang.String)   
	 */
	@Override
	public Long scard(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sismember(java.lang.String, java.lang.String)   
	 */
	@Override
	public Boolean sismember(String key, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#srandmember(java.lang.String)   
	 */
	@Override
	public String srandmember(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#srandmember(java.lang.String, int)   
	 */
	@Override
	public List<String> srandmember(String key, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#strlen(java.lang.String)   
	 */
	@Override
	public Long strlen(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zadd(java.lang.String, double, java.lang.String)   
	 */
	@Override
	public Long zadd(String key, double score, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zadd(java.lang.String, double, java.lang.String, redis.clients.jedis.params.sortedset.ZAddParams)   
	 */
	@Override
	public Long zadd(String key, double score, String member, ZAddParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zadd(java.lang.String, java.util.Map)   
	 */
	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zadd(java.lang.String, java.util.Map, redis.clients.jedis.params.sortedset.ZAddParams)   
	 */
	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrange(java.lang.String, long, long)   
	 */
	@Override
	public Set<String> zrange(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrem(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long zrem(String key, String... member) {
		
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zincrby(java.lang.String, double, java.lang.String)   
	 */
	@Override
	public Double zincrby(String key, double score, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zincrby(java.lang.String, double, java.lang.String, redis.clients.jedis.params.sortedset.ZIncrByParams)   
	 */
	@Override
	public Double zincrby(String key, double score, String member, ZIncrByParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrank(java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zrank(String key, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrank(java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zrevrank(String key, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrange(java.lang.String, long, long)   
	 */
	@Override
	public Set<String> zrevrange(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeWithScores(java.lang.String, long, long)   
	 */
	@Override
	public Set<Tuple> zrangeWithScores(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeWithScores(java.lang.String, long, long)   
	 */
	@Override
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zcard(java.lang.String)   
	 */
	@Override
	public Long zcard(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zscore(java.lang.String, java.lang.String)   
	 */
	@Override
	public Double zscore(String key, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sort(java.lang.String)   
	 */
	@Override
	public List<String> sort(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sort(java.lang.String, redis.clients.jedis.SortingParams)   
	 */
	@Override
	public List<String> sort(String key, SortingParams sortingParameters) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zcount(java.lang.String, double, double)   
	 */
	@Override
	public Long zcount(String key, double min, double max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zcount(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zcount(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScore(java.lang.String, double, double)   
	 */
	@Override
	public Set<String> zrangeByScore(String key, double min, double max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScore(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<String> zrangeByScore(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScore(java.lang.String, double, double)   
	 */
	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScore(java.lang.String, double, double, int, int)   
	 */
	@Override
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScore(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<String> zrevrangeByScore(String key, String max, String min) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScore(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScore(java.lang.String, double, double, int, int)   
	 */
	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScoreWithScores(java.lang.String, double, double)   
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScoreWithScores(java.lang.String, double, double)   
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScoreWithScores(java.lang.String, double, double, int, int)   
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScore(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScoreWithScores(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScoreWithScores(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByScoreWithScores(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScoreWithScores(java.lang.String, double, double, int, int)   
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByScoreWithScores(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zremrangeByRank(java.lang.String, long, long)   
	 */
	@Override
	public Long zremrangeByRank(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zremrangeByScore(java.lang.String, double, double)   
	 */
	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zremrangeByScore(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zremrangeByScore(String key, String start, String end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zlexcount(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zlexcount(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByLex(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<String> zrangeByLex(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrangeByLex(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByLex(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zrevrangeByLex(java.lang.String, java.lang.String, java.lang.String, int, int)   
	 */
	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zremrangeByLex(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long zremrangeByLex(String key, String min, String max) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#linsert(java.lang.String, redis.clients.jedis.BinaryClient.LIST_POSITION, java.lang.String, java.lang.String)   
	 */
	@Override
	public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#lpushx(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long lpushx(String key, String... string) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#rpushx(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long rpushx(String key, String... string) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#blpop(java.lang.String)   
	 */
	@Override
	public List<String> blpop(String arg) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#blpop(int, java.lang.String)   
	 */
	@Override
	public List<String> blpop(int timeout, String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#brpop(java.lang.String)   
	 */
	@Override
	public List<String> brpop(String arg) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#brpop(int, java.lang.String)   
	 */
	@Override
	public List<String> brpop(int timeout, String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#del(java.lang.String)   
	 */
	@Override
	public Long del(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#echo(java.lang.String)   
	 */
	@Override
	public String echo(String string) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#move(java.lang.String, int)   
	 */
	@Override
	public Long move(String key, int dbIndex) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#bitcount(java.lang.String)   
	 */
	@Override
	public Long bitcount(String key) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#bitcount(java.lang.String, long, long)   
	 */
	@Override
	public Long bitcount(String key, long start, long end) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#bitpos(java.lang.String, boolean)   
	 */
	@Override
	public Long bitpos(String key, boolean value) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#bitpos(java.lang.String, boolean, redis.clients.jedis.BitPosParams)   
	 */
	@Override
	public Long bitpos(String key, boolean value, BitPosParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hscan(java.lang.String, int)   
	 */
	@Override
	public ScanResult<Entry<String, String>> hscan(String key, int cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sscan(java.lang.String, int)   
	 */
	@Override
	public ScanResult<String> sscan(String key, int cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zscan(java.lang.String, int)   
	 */
	@Override
	public ScanResult<Tuple> zscan(String key, int cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hscan(java.lang.String, java.lang.String)   
	 */
	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#hscan(java.lang.String, java.lang.String, redis.clients.jedis.ScanParams)   
	 */
	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sscan(java.lang.String, java.lang.String)   
	 */
	@Override
	public ScanResult<String> sscan(String key, String cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#sscan(java.lang.String, java.lang.String, redis.clients.jedis.ScanParams)   
	 */
	@Override
	public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zscan(java.lang.String, java.lang.String)   
	 */
	@Override
	public ScanResult<Tuple> zscan(String key, String cursor) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#zscan(java.lang.String, java.lang.String, redis.clients.jedis.ScanParams)   
	 */
	@Override
	public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#pfadd(java.lang.String, java.lang.String[])   
	 */
	@Override
	public Long pfadd(String key, String... elements) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#pfcount(java.lang.String)   
	 */
	@Override
	public long pfcount(String key) {
		return 0;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geoadd(java.lang.String, double, double, java.lang.String)   
	 */
	@Override
	public Long geoadd(String key, double longitude, double latitude, String member) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geoadd(java.lang.String, java.util.Map)   
	 */
	@Override
	public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geodist(java.lang.String, java.lang.String, java.lang.String)   
	 */
	@Override
	public Double geodist(String key, String member1, String member2) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geodist(java.lang.String, java.lang.String, java.lang.String, redis.clients.jedis.GeoUnit)   
	 */
	@Override
	public Double geodist(String key, String member1, String member2, GeoUnit unit) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geohash(java.lang.String, java.lang.String[])   
	 */
	@Override
	public List<String> geohash(String key, String... members) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#geopos(java.lang.String, java.lang.String[])   
	 */
	@Override
	public List<GeoCoordinate> geopos(String key, String... members) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#georadius(java.lang.String, double, double, double, redis.clients.jedis.GeoUnit)   
	 */
	@Override
	public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius,
			GeoUnit unit) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#georadius(java.lang.String, double, double, double, redis.clients.jedis.GeoUnit, redis.clients.jedis.params.geo.GeoRadiusParam)   
	 */
	@Override
	public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit,
			GeoRadiusParam param) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#georadiusByMember(java.lang.String, java.lang.String, double, redis.clients.jedis.GeoUnit)   
	 */
	@Override
	public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#georadiusByMember(java.lang.String, java.lang.String, double, redis.clients.jedis.GeoUnit, redis.clients.jedis.params.geo.GeoRadiusParam)   
	 */
	@Override
	public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit,
			GeoRadiusParam param) {
		return null;
	}

	/*    
	 * @see redis.clients.jedis.JedisCommands#bitfield(java.lang.String, java.lang.String[])   
	 */
	@Override
	public List<Long> bitfield(String key, String... arguments) {
		return null;
	}

	/*    
	 * @see com.kowloon.tools.redis.IRedisTemplate#publish(java.lang.String, java.lang.String)   
	 */
	@Override
	public Long publish(String channel, String message) {
		return null;
	}

	/*    
	 * @see com.kowloon.tools.redis.IRedisTemplate#subscribe(redis.clients.jedis.JedisPubSub, java.lang.String[])   
	 */
	@Override
	public void subscribe(JedisPubSub jedisPubSub, String... channels) {

	}

	/*    
	 * @see com.kowloon.tools.redis.IRedisTemplate#psubscribe(redis.clients.jedis.JedisPubSub, java.lang.String[])   
	 */
	@Override
	public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {

	}

}

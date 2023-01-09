package com.mingxinbeijing.common.tool;
/**
 * 生成ID的工具类，雪花算法
 * SnowFlake：雪花算法，Twitter开源的由64位整数组成分布式ID，性能较高，并且在单机上递增。GitHub上官方地址：https://github.com/twitter-archive/snowflake/tree/snowflake-2010 。
 * @author jiangzhiwei
 * @date 2022/12/01
 */
public class IDUtils {
	//简单一点，雪花算法，默认数据中心、机器ID都为1
	static SnowFlake snowFlake = new SnowFlake(1, 1);
	public static long createID() {	
		return snowFlake.nextId();
	}

}

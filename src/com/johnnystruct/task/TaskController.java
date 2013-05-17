package com.johnnystruct.task;

import java.util.concurrent.ConcurrentHashMap;

import android.os.AsyncTask;

import com.johnnystruct.bean.TaskResult;

/**
 * 后台任务的调度器,在AsyncTask的onPreExecute()和onPostExecute()里
 * 分别执行addTask2Container和removeTaskFromContainer操作
 * 
 * @author YuZhiQiang
 * @createTime 2012.11.29
 */
public class TaskController {

	public static ConcurrentHashMap<Integer, AsyncTask<Object, Void, TaskResult>> taskContainer = new ConcurrentHashMap<Integer, AsyncTask<Object, Void, TaskResult>>();

	/**
	 * 添加任务到容器
	 */
	public static void addTask2Container(Integer key,
			AsyncTask<Object, Void, TaskResult> task) {
		taskContainer.put(key, task);
	}

	/**
	 * 从容器内存移除任务
	 */
	public static void removeTaskFromContainer(Integer key) {
		taskContainer.remove(key);
	}

	/**
	 * 取消任务
	 * 
	 * @param key
	 */
	public static void cancelTask(Integer key) {
		AsyncTask<Object, Void, TaskResult> task = taskContainer.get(key);
		if (task != null) {
			task.cancel(true);
			taskContainer.remove(key);
		}
	}

	/**
	 * 判断任务是否在执行
	 * 
	 * @param key
	 * @return
	 */
	public static boolean exist(Integer key) {
		return taskContainer.containsKey(key);
	}
}

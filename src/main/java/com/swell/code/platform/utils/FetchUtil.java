package com.swell.code.platform.utils;//package com.swell.pmss.platform.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.swell.pmss.platform.entity.ParamEntity;
//import com.swell.pmss.platform.entity.ParamPageEntity;
//
///**
// * @author fei.yang
// * @time 创建时间：2018年11月12日 下午1:47:58
// * 
// * @see 抓取数据工具类
// */
//
//public class FetchUtil {
//
//	private static boolean isTest = false;
//	public static final String QUERY = "query";
//	public static final String QUERY_COUNT = "queryCount";
//
//	/**
//	 * 抓取数据
//	 * 
//	 * @param serverHost接口地址
//	 * @param requestBody参数串
//	 * @return
//	 */
//	public static String doFetch(String serverHost, String requestBody) {
//		String result = "";
//		if (isTest) {
//
//			// 测试查询
//			JSONObject json = JSONObject.parseObject(requestBody);
//			ParamEntity paramEntity = JSONObject.toJavaObject(json, ParamEntity.class);
//			if (paramEntity.getHandleType().equals(FetchUtil.QUERY_COUNT)) {
//				result = getQueryCountTestData();
//			} else {
//				ParamPageEntity paramPageEntity = paramEntity.getParameter().get(0);
//				result = getQueryItemsTestData(paramPageEntity.getPage(), paramPageEntity.getPageSize());
//			}
//		} else {
//			// 正式查询
//			result = HttpUtil.postBody(serverHost, requestBody);
//		}
//
//		return result;
//	}
//
//	/**
//	 * 查询条数参数
//	 * 
//	 * @param companyId
//	 * @param tableName
//	 * @return
//	 */
//	public static ParamEntity getQueryCountParam(String companyId, String tableName) {
//		ParamPageEntity paramPageEntity = new ParamPageEntity();
//		List<ParamPageEntity> parameter = new ArrayList<>();
//		parameter.add(paramPageEntity);
//		ParamEntity paramEntity = new ParamEntity();
//		paramEntity.setParameter(parameter);
//		paramEntity.setCompanyId(companyId);
//		paramEntity.setTableName(tableName);
//		paramEntity.setHandleType(QUERY_COUNT);
//		return paramEntity;
//	}
//
//	/**
//	 * 查询数据参数
//	 * 
//	 * @param companyId
//	 * @param tableName
//	 * @return
//	 */
//	public static ParamEntity getQueryItemsParam(String companyId, String tableName) {
//		ParamPageEntity paramPageEntity = new ParamPageEntity();
//		List<ParamPageEntity> parameter = new ArrayList<>();
//		parameter.add(paramPageEntity);
//		ParamEntity paramEntity = new ParamEntity();
//		paramEntity.setParameter(parameter);
//		paramEntity.setCompanyId(companyId);
//		paramEntity.setTableName(tableName);
//		paramEntity.setHandleType(QUERY);
//		return paramEntity;
//	}
//
//	/**
//	 * 测试数据-总条数
//	 * 
//	 * @return
//	 */
//	private static String getQueryCountTestData() {
//		JSONObject jsonResult = new JSONObject();
//		jsonResult.put("respMsg", "查询成功!");
//		jsonResult.put("respCode", "0000");
//
//		JSONObject respResult = new JSONObject();
//		respResult.put("total", 52);
//
//		JSONArray array = new JSONArray();
//
//		respResult.put("dataList", array);
//		jsonResult.put("respResult", respResult);
//		return jsonResult.toString();
//	}
//
//	/**
//	 * 测试数据-分页记录
//	 * 
//	 * @return
//	 */
//	private static String getQueryItemsTestData(int page, int pageSize) {
//		JSONObject jsonResult = new JSONObject();
//		jsonResult.put("respMsg", "查询成功!");
//		jsonResult.put("respCode", "0000");
//
//		JSONObject respResult = new JSONObject();
//		int actualTotal = 0;
//
//		JSONArray array = new JSONArray();
//		// 共测试52条
//		for (int i = 0; i < 52; i++) {
//
//			if (i >= (page - 1) * pageSize && i < page * pageSize) {
//				JSONObject json = new JSONObject();
//				json.put("rid", "AAA" + i);
//				json.put("syrklbdm", Math.round((Math.random() + 1) * 100000));
//				json.put("syrklbhz", "张三BBB" + i);
//				array.add(json);
//				actualTotal++;
//			}
//		}
//		respResult.put("total", actualTotal);
//
//		respResult.put("dataList", array);
//		jsonResult.put("respResult", respResult);
//		return jsonResult.toString();
//	}
//}

package cn.senninha.web.util;

import cn.senninha.web.domain.Result;

public class resultUtil {
    // 普通结果成功
  public static final Result success(Object data, Object pagintion) {
      Result result = new Result(data, "success", 200, pagintion);
      return result;
  }

  // 列表结果成功
  public static final Result success(Object data) {
      Result result = new Result(data, "success", 200);
      return result;
  }

  // 失败
  public static final Result fail(String message, int status, Object data) {
      Result result = new Result(data, message, status);
      return result;
  }
}


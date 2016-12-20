package org.allen.springmvc.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.utils.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cat")
public class CatSampleController {

    /**
     * log4j中配置文件中添加cat的appender，则错误日志会打入到CAT中
     *
     * @return
     */
    @RequestMapping(value = "error", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponseDTO logError() {
        Logger.error(this, "test cat log error", new RuntimeException("test cat log error"));
        return new ApiResponseDTO().setRetCode("99").setRetMsg("System error");
    }

    /**
     * Transaction 记录一段代码的运行时间
     * @return
     */
    @RequestMapping(value = "transaction", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponseDTO transaction() {
        Transaction t = Cat.newTransaction("YourTransactionType", "YourTransactionName");
        try {
            // your business here
            Thread.sleep(500);
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            Logger.error(this, e.getMessage(), e);
            t.setStatus(e);
        } finally {
            t.complete();
        }
        return new ApiResponseDTO().setRetCode("00").setRetMsg("Success");
    }

    /**
     * Event 记录一个业务逻辑的运行次数
     * @return
     */
    @RequestMapping(value = "event", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponseDTO event() {
        Cat.logEvent("YourEventType", "YourEventName1");
        Cat.logEvent("YourEventType", "YourEventName2", Event.SUCCESS, "a=1&b=2");
        return new ApiResponseDTO().setRetCode("00").setRetMsg("Success");
    }

    /**
     * Metric 记录一个指标出现的次数，平均值，总和
     * @return
     */
    @RequestMapping(value = "metric", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponseDTO metric() {
        Cat.logMetricForCount("Metric1");
        Cat.logMetricForCount("Metric2", 10);
        return new ApiResponseDTO().setRetCode("00").setRetMsg("Success");
    }
}

package sbs.toutiao.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 例子rest controller
 *
 * @author toutiao.sbs
 * @since 2023年04月01日 08:52
 */
@Slf4j
@RestController
public class DemoController {


    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public DemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "Hello, World!";
    }

    private final JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/jdbcTest",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> jdbcTest(){
        String sql="select * from t_tableName limit 1";//SQL查询语句
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping(value = "/mybatisTest",method = RequestMethod.GET)
    @ResponseBody
    public void mybatisTest(){
//        QueryWrapper<TTableName> tEthWrapper = new QueryWrapper<>();
//        tEthWrapper.eq("id", 40L);
//        long count = tService.count(tEthWrapper);
//        TTableName one = tService.getOne(tEthWrapper);
//        log.info("查询数据:{}", count);
//        log.info("查询数据:{}", GSON.toJson(one));
    }


    @RequestMapping(value="/beat",method = RequestMethod.POST)
    @ResponseBody
    public String beat(@RequestBody String body){
        log.info("beat body:{}", body);
        return "{\n"
            + "      \"id\": 1,\n"
            + "      \"code\": 1,\n"
            + "      \"message\": \"beat success\",\n"
            + "      \"data\": \"\"\n"
            + "    }";
    }

    @RequestMapping(value="/notifyBeat",method = RequestMethod.POST)
    @ResponseBody
    public String notifyBeat(@RequestBody String body){
        log.info("notifyBeat body:{}", body);
        return "{\n"
            + "      \"id\": 1,\n"
            + "      \"code\": 1,\n"
            + "      \"message\": \"notifyBeat success\",\n"
            + "      \"data\": \"\"\n"
            + "    }";
    }
}






package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 培训
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/peixun")
public class PeixunController {
    private static final Logger logger = LoggerFactory.getLogger(PeixunController.class);

    @Autowired
    private PeixunService peixunService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KechengService kechengService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = peixunService.queryPage(params);

        //字典表数据转换
        List<PeixunView> list =(List<PeixunView>)page.getList();
        for(PeixunView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PeixunEntity peixun = peixunService.selectById(id);
        if(peixun !=null){
            //entity转view
            PeixunView view = new PeixunView();
            BeanUtils.copyProperties( peixun , view );//把实体数据重构到view中

                //级联表
                KechengEntity kecheng = kechengService.selectById(peixun.getKechengId());
                if(kecheng != null){
                    BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKechengId(kecheng.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(peixun.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PeixunEntity peixun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peixun:{}",this.getClass().getName(),peixun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            peixun.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PeixunEntity> queryWrapper = new EntityWrapper<PeixunEntity>()
            .eq("peixun_uuid_number", peixun.getPeixunUuidNumber())
            .eq("kecheng_id", peixun.getKechengId())
            .eq("yonghu_id", peixun.getYonghuId())
            .eq("peixun_types", peixun.getPeixunTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunEntity peixunEntity = peixunService.selectOne(queryWrapper);
        if(peixunEntity==null){
            peixun.setCreateTime(new Date());
            peixunService.insert(peixun);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeixunEntity peixun, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,peixun:{}",this.getClass().getName(),peixun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            peixun.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PeixunEntity> queryWrapper = new EntityWrapper<PeixunEntity>()
            .notIn("id",peixun.getId())
            .andNew()
            .eq("peixun_uuid_number", peixun.getPeixunUuidNumber())
            .eq("kecheng_id", peixun.getKechengId())
            .eq("yonghu_id", peixun.getYonghuId())
            .eq("peixun_types", peixun.getPeixunTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunEntity peixunEntity = peixunService.selectOne(queryWrapper);
        if(peixunEntity==null){
            peixunService.updateById(peixun);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        peixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PeixunEntity> peixunList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PeixunEntity peixunEntity = new PeixunEntity();
//                            peixunEntity.setPeixunUuidNumber(data.get(0));                    //课程名称 要改的
//                            peixunEntity.setKechengId(Integer.valueOf(data.get(0)));   //课程 要改的
//                            peixunEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            peixunEntity.setPeixunOnTime(sdf.parse(data.get(0)));          //培训开始时间 要改的
//                            peixunEntity.setPeixunDownTime(sdf.parse(data.get(0)));          //培训结束时间 要改的
//                            peixunEntity.setPeixunTypes(Integer.valueOf(data.get(0)));   //培训类型 要改的
//                            peixunEntity.setCultivateContent("");//详情和图片
//                            peixunEntity.setPeixunFenshu(data.get(0));                    //成绩 要改的
//                            peixunEntity.setCreateTime(date);//时间
                            peixunList.add(peixunEntity);


                            //把要查询是否重复的字段放入map中
                                //课程名称
                                if(seachFields.containsKey("peixunUuidNumber")){
                                    List<String> peixunUuidNumber = seachFields.get("peixunUuidNumber");
                                    peixunUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> peixunUuidNumber = new ArrayList<>();
                                    peixunUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("peixunUuidNumber",peixunUuidNumber);
                                }
                        }

                        //查询是否重复
                         //课程名称
                        List<PeixunEntity> peixunEntities_peixunUuidNumber = peixunService.selectList(new EntityWrapper<PeixunEntity>().in("peixun_uuid_number", seachFields.get("peixunUuidNumber")));
                        if(peixunEntities_peixunUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeixunEntity s:peixunEntities_peixunUuidNumber){
                                repeatFields.add(s.getPeixunUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [课程名称] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        peixunService.insertBatch(peixunList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}

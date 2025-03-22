package com.entity.model;

import com.entity.PeixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 培训
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeixunModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String peixunUuidNumber;


    /**
     * 课程
     */
    private Integer kechengId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 培训开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date peixunOnTime;


    /**
     * 培训结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date peixunDownTime;


    /**
     * 培训类型
     */
    private Integer peixunTypes;


    /**
     * 培训内容
     */
    private String cultivateContent;


    /**
     * 成绩
     */
    private Double peixunFenshu;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：课程名称
	 */
    public String getPeixunUuidNumber() {
        return peixunUuidNumber;
    }


    /**
	 * 设置：课程名称
	 */
    public void setPeixunUuidNumber(String peixunUuidNumber) {
        this.peixunUuidNumber = peixunUuidNumber;
    }
    /**
	 * 获取：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 设置：课程
	 */
    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：培训开始时间
	 */
    public Date getPeixunOnTime() {
        return peixunOnTime;
    }


    /**
	 * 设置：培训开始时间
	 */
    public void setPeixunOnTime(Date peixunOnTime) {
        this.peixunOnTime = peixunOnTime;
    }
    /**
	 * 获取：培训结束时间
	 */
    public Date getPeixunDownTime() {
        return peixunDownTime;
    }


    /**
	 * 设置：培训结束时间
	 */
    public void setPeixunDownTime(Date peixunDownTime) {
        this.peixunDownTime = peixunDownTime;
    }
    /**
	 * 获取：培训类型
	 */
    public Integer getPeixunTypes() {
        return peixunTypes;
    }


    /**
	 * 设置：培训类型
	 */
    public void setPeixunTypes(Integer peixunTypes) {
        this.peixunTypes = peixunTypes;
    }
    /**
	 * 获取：培训内容
	 */
    public String getCultivateContent() {
        return cultivateContent;
    }


    /**
	 * 设置：培训内容
	 */
    public void setCultivateContent(String cultivateContent) {
        this.cultivateContent = cultivateContent;
    }
    /**
	 * 获取：成绩
	 */
    public Double getPeixunFenshu() {
        return peixunFenshu;
    }


    /**
	 * 设置：成绩
	 */
    public void setPeixunFenshu(Double peixunFenshu) {
        this.peixunFenshu = peixunFenshu;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

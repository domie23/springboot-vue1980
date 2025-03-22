package com.entity.vo;

import com.entity.PeixunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 培训
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("peixun")
public class PeixunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程名称
     */

    @TableField(value = "peixun_uuid_number")
    private String peixunUuidNumber;


    /**
     * 课程
     */

    @TableField(value = "kecheng_id")
    private Integer kechengId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 培训开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "peixun_on_time")
    private Date peixunOnTime;


    /**
     * 培训结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "peixun_down_time")
    private Date peixunDownTime;


    /**
     * 培训类型
     */

    @TableField(value = "peixun_types")
    private Integer peixunTypes;


    /**
     * 培训内容
     */

    @TableField(value = "cultivate_content")
    private String cultivateContent;


    /**
     * 成绩
     */

    @TableField(value = "peixun_fenshu")
    private Double peixunFenshu;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课程名称
	 */
    public String getPeixunUuidNumber() {
        return peixunUuidNumber;
    }


    /**
	 * 获取：课程名称
	 */

    public void setPeixunUuidNumber(String peixunUuidNumber) {
        this.peixunUuidNumber = peixunUuidNumber;
    }
    /**
	 * 设置：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：培训开始时间
	 */
    public Date getPeixunOnTime() {
        return peixunOnTime;
    }


    /**
	 * 获取：培训开始时间
	 */

    public void setPeixunOnTime(Date peixunOnTime) {
        this.peixunOnTime = peixunOnTime;
    }
    /**
	 * 设置：培训结束时间
	 */
    public Date getPeixunDownTime() {
        return peixunDownTime;
    }


    /**
	 * 获取：培训结束时间
	 */

    public void setPeixunDownTime(Date peixunDownTime) {
        this.peixunDownTime = peixunDownTime;
    }
    /**
	 * 设置：培训类型
	 */
    public Integer getPeixunTypes() {
        return peixunTypes;
    }


    /**
	 * 获取：培训类型
	 */

    public void setPeixunTypes(Integer peixunTypes) {
        this.peixunTypes = peixunTypes;
    }
    /**
	 * 设置：培训内容
	 */
    public String getCultivateContent() {
        return cultivateContent;
    }


    /**
	 * 获取：培训内容
	 */

    public void setCultivateContent(String cultivateContent) {
        this.cultivateContent = cultivateContent;
    }
    /**
	 * 设置：成绩
	 */
    public Double getPeixunFenshu() {
        return peixunFenshu;
    }


    /**
	 * 获取：成绩
	 */

    public void setPeixunFenshu(Double peixunFenshu) {
        this.peixunFenshu = peixunFenshu;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

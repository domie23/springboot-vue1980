package com.entity.view;

import com.entity.PeixunCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 培训评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("peixun_commentback")
public class PeixunCommentbackView extends PeixunCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 peixun
			/**
			* 课程名称
			*/
			private String peixunUuidNumber;
			/**
			* 培训 的 用户
			*/
			private Integer peixunYonghuId;
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
				* 培训类型的值
				*/
				private String peixunValue;
			/**
			* 培训内容
			*/
			private String cultivateContent;
			/**
			* 成绩
			*/
			private Double peixunFenshu;

		//级联表 yonghu
			/**
			* 姓名
			*/
			private String yonghuName;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 头像
			*/
			private String yonghuPhoto;

	public PeixunCommentbackView() {

	}

	public PeixunCommentbackView(PeixunCommentbackEntity peixunCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, peixunCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set peixun

					/**
					* 获取： 课程名称
					*/
					public String getPeixunUuidNumber() {
						return peixunUuidNumber;
					}
					/**
					* 设置： 课程名称
					*/
					public void setPeixunUuidNumber(String peixunUuidNumber) {
						this.peixunUuidNumber = peixunUuidNumber;
					}


					/**
					* 获取：培训 的 用户
					*/
					public Integer getPeixunYonghuId() {
						return peixunYonghuId;
					}
					/**
					* 设置：培训 的 用户
					*/
					public void setPeixunYonghuId(Integer peixunYonghuId) {
						this.peixunYonghuId = peixunYonghuId;
					}


					/**
					* 获取： 培训开始时间
					*/
					public Date getPeixunOnTime() {
						return peixunOnTime;
					}
					/**
					* 设置： 培训开始时间
					*/
					public void setPeixunOnTime(Date peixunOnTime) {
						this.peixunOnTime = peixunOnTime;
					}

					/**
					* 获取： 培训结束时间
					*/
					public Date getPeixunDownTime() {
						return peixunDownTime;
					}
					/**
					* 设置： 培训结束时间
					*/
					public void setPeixunDownTime(Date peixunDownTime) {
						this.peixunDownTime = peixunDownTime;
					}

					/**
					* 获取： 培训类型
					*/
					public Integer getPeixunTypes() {
						return peixunTypes;
					}
					/**
					* 设置： 培训类型
					*/
					public void setPeixunTypes(Integer peixunTypes) {
						this.peixunTypes = peixunTypes;
					}


						/**
						* 获取： 培训类型的值
						*/
						public String getPeixunValue() {
							return peixunValue;
						}
						/**
						* 设置： 培训类型的值
						*/
						public void setPeixunValue(String peixunValue) {
							this.peixunValue = peixunValue;
						}

					/**
					* 获取： 培训内容
					*/
					public String getCultivateContent() {
						return cultivateContent;
					}
					/**
					* 设置： 培训内容
					*/
					public void setCultivateContent(String cultivateContent) {
						this.cultivateContent = cultivateContent;
					}

					/**
					* 获取： 成绩
					*/
					public Double getPeixunFenshu() {
						return peixunFenshu;
					}
					/**
					* 设置： 成绩
					*/
					public void setPeixunFenshu(Double peixunFenshu) {
						this.peixunFenshu = peixunFenshu;
					}







				//级联表的get和set yonghu

					/**
					* 获取： 姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}

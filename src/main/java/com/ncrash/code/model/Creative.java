package com.ncrash.code.model;

import java.io.Serializable;

/**
 * Creative.java
 * 
 * @author NCrash
 * @category Samsung InternetTV 2nd
 * @since 2009.11.11 
 */
public class Creative implements Serializable {

	private static final long serialVersionUID = 1363593972562922572L;

	private Integer campaignKey;
	private String campaignId;
	private Integer creativeKey;
	private String creativeXML;
	private String id;
	private String name;
	private String clickUrl;
	private String discount;
	private String displayFlag;
	private String url; // FileNameOrUrl 컬럼
	private String creativeContent;
	private Boolean inputAdInfo;
	
	/**
	 * 소재가 속한 캠페인의 고유 키<br>
	 * DB : Campaign.CampaignKey
	 * 
	 * @return
	 */
	public Integer getCampaignKey() {
		return campaignKey;
	}

	public void setCampaignKey(Integer campaignKey) {
		this.campaignKey = campaignKey;
	}

	/**
	 * 소재가 속한 캠페인의 아이디<br>
	 * DB : Campaign.Id
	 * 
	 * @return
	 */
	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * 소재 고유 키<br>
	 * DB : Creative.CreativeKey
	 * 
	 * @return
	 */
	public Integer getCreativeKey() {
		return creativeKey;
	}

	public void setCreativeKey(Integer creativeKey) {
		this.creativeKey = creativeKey;
	}

	/**
	 * 소재의 타입 키<br>
	 * DB : Creative.CreativeTypeKey
	 * @return
	 */
	public String getCreativeXML() {
		return creativeXML;
	}

	public void setCreativeXML(String creativeXML) {
		this.creativeXML = creativeXML;
	}

	/**
	 * 소재 아이디<br>
	 * DB : Creative.Id
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 소재 이름<br>
	 * DB : Creative.Name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 소재 상태<br>
	 * DB : Creative.Name
	 * 
	 * @return
	 */
	public String getStatus() {
		return name;
	}
	
	public void setStatus(String status) {
		this.name = status;
	}

	/**
	 * 클릭 URL<br>
	 * DB : Creative.ClickUrl
	 * 
	 * @return
	 */
	public String getClickUrl() {
		return clickUrl;
	}

	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}

	/**
	 * 임프레션 카운트 결정<br>
	 * <br>
	 * <ul>
	 * <li>소재용 creative : Yes
	 * <li>임프레션용 creative : No
	 * </ul>
	 * DB : Creative.Discount
	 * 
	 * @return
	 */
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * 배너를 보이게 할 것인지 결정<br>
	 * <br>
	 * <ul>
	 * <li>Approved 소재용 creative : Yes
	 * <li>임프레션용 creative : Yes
	 * <li>Approved 상태 외 소재용 creative : No
	 * </ul>
	 * DB : Creative.DisplayFlag
	 * 
	 * @return
	 */
	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	/**
	 * 소재 XML URL<br>
	 * DB : Creative.FileNameOrUrl
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 소재 파일 내용<br>
	 * DB : Creative.FileNameOrUrl 내용
	 * 
	 * @return
	 */
	public String getCreativeContent() {
		return creativeContent.replaceAll("(?i)(seq=\"\\d*\"\\s*|parentseq=\"\\d*\"\\s*)", "");
	}

	public void setCreativeContent(String creativeContent) {
		this.creativeContent = creativeContent;
	}


    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    public String toString()
    {
        final String TAB = "\n    ";
        
        String retValue = "";
        
        retValue = "Creative ( "
            + super.toString() + TAB
            + "campaignKey = " + this.campaignKey + TAB
            + "campaignId = " + this.campaignId + TAB
            + "creativeKey = " + this.creativeKey + TAB
            + "creativeXML = " + this.creativeXML + TAB
            + "id = " + this.id + TAB
            + "name = " + this.name + TAB
            + "clickUrl = " + this.clickUrl + TAB
            + "discount = " + this.discount + TAB
            + "displayFlag = " + this.displayFlag + TAB
            + "url = " + this.url + TAB
            + "creativeContent = " + this.creativeContent + TAB
            + " )";
    
        return retValue;
    }

	/**
	 * AdInfo url 등록 선택 여부<br>
	 * DB : Creative.InputAdInfo
	 * 
	 * @return
	 */
	public void setInputAdInfo(Boolean inputAdInfo) {
		this.inputAdInfo = inputAdInfo;
	}

	public Boolean isInputAdInfo() {
		return inputAdInfo;
	}
	
	public Boolean getInputAdInfo() {
		return inputAdInfo;
	}
}

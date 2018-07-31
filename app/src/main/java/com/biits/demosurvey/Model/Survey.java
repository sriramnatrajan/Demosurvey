package com.biits.demosurvey.Model;

public class Survey {
    private String SurveyId;
    private String Survey_CompanyProjectId;
    private String SurveyName;
    private String SurveyDescription;
    private String SurveyStartDate;
    private String SurveyEndDate;
    private String SurveyStatus;
    private String SurveyisDelete;



    public Survey() {
    }

    public Survey(String SurveyId, String Survey_CompanyProjectId, String SurveyName, String SurveyDescription, String SurveyStartDate,
                  String SurveyEndDate, String SurveyStatus, String SurveyisDelete) {

        this.SurveyId = SurveyId;
        this.Survey_CompanyProjectId = Survey_CompanyProjectId;
        this.SurveyName = SurveyName;
        this.SurveyDescription = SurveyDescription;
        this.SurveyStartDate = SurveyStartDate;
        this.SurveyEndDate = SurveyEndDate;
        this.SurveyStatus = SurveyStatus;
        this.SurveyisDelete = SurveyisDelete;
    }



    public String getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(String surveyId) {
        SurveyId = surveyId;
    }

    public String getSurvey_CompanyProjectId() {
        return Survey_CompanyProjectId;
    }

    public void setSurvey_CompanyProjectId(String survey_CompanyProjectId) {
        Survey_CompanyProjectId = survey_CompanyProjectId;
    }

    public String getSurveyName() {
        return SurveyName;
    }

    public void setSurveyName(String surveyName) {
        SurveyName = surveyName;
    }

    public String getSurveyDescription() {
        return SurveyDescription;
    }

    public void setSurveyDescription(String surveyDescription) {
        SurveyDescription = surveyDescription;
    }

    public String getSurveyStartDate() {
        return SurveyStartDate;
    }

    public void setSurveyStartDate(String surveyStartDate) {
        SurveyStartDate = surveyStartDate;
    }

    public String getSurveyEndDate() {
        return SurveyEndDate;
    }

    public void setSurveyEndDate(String surveyEndDate) {
        SurveyEndDate = surveyEndDate;
    }

    public String getSurveyStatus() {
        return SurveyStatus;
    }

    public void setSurveyStatus(String surveyStatus) {
        SurveyStatus = surveyStatus;
    }

    public String getSurveyisDelete() {
        return SurveyisDelete;
    }

    public void setSurveyisDelete(String surveyisDelete) {
        SurveyisDelete = surveyisDelete;
    }





}
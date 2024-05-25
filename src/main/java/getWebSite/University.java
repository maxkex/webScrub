package getWebSite;

import java.util.List;

class University {
    private String urlCollegeBoard;
    private String univerName;
    private String address;
    private String mapLink;
    private String city;
    private String state;
    private String schoolTypeByYears;
    private String schoolTypeByDesignation;
    private String schoolSize;
    private String schoolSetting;
    private String graduationRate;
    private String satScoreRange;
    private String urlUniverWebSite;
    private String phone;
    private String satTotalRange;
    private String satReadingRange;
    private String satMathRange;
    private String acceptanceRate;
    private String totalApplicants;
    private String admittedAppl;
    private String enrolledAppl;
    private String applFee;
    private String regApplDate;
    private String studentsReceivFinAid;
    private String costAvrgPerYearAfterAid;
    private String avrgAidPackage;
    private String costInState;
    private String costOutOfState;
    private String costFor110kHHIncome;
    private String costFor75to100HHIncome;
    private String costFor48to75kHHIncome;
    private String costFor30to48kHHIncome;
    private String costFor30kToLessHHIncome;
    private String costHousing;
    private String costBooksSuppl;
    private String costTransportation;
    private String underGradStudents;
    private String regularAppDue;
    private String earlyDecisionAppDue;
    private String earlyActionAppDue;
    private String studentFacultyRatio;
    private String majorsAvailable;
    private String retentionRate;
    private String offersCredits;
    private String offersAdvancedPlacements;
    
    public void setCostAvrgPerYearAfterAid(String costAvrgPerYearAfterAid) {
        this.costAvrgPerYearAfterAid = costAvrgPerYearAfterAid;
    }

    public String getCostAvrgPerYearAfterAid() {
        return costAvrgPerYearAfterAid;
    }

    public void setAvrgAidPackage(String avrgAidPackage) {
        this.avrgAidPackage = avrgAidPackage;
    }

    public String getAvrgAidPackage() {
        return avrgAidPackage;
    }
    public void setCostFor75to100HHIncome(String costFor75to100HHIncome) {
        this.costFor75to100HHIncome = costFor75to100HHIncome;
    }

    public String getCostFor75to100HHIncome() {
        return costFor75to100HHIncome;
    }

    public void setCostFor48to75kHHIncome(String costFor48to75kHHIncome) {
        this.costFor48to75kHHIncome = costFor48to75kHHIncome;
    }

    public String getCostFor48to75kHHIncome() {
        return costFor48to75kHHIncome;
    }

    public void setCostFor30to48kHHIncome(String costFor30to48kHHIncome) {
        this.costFor30to48kHHIncome = costFor30to48kHHIncome;
    }

    public String getCostFor30to48kHHIncome() {
        return costFor30to48kHHIncome;
    }

    public void setCostFor30kToLessHHIncome(String costFor30kToLessHHIncome) {
        this.costFor30kToLessHHIncome = costFor30kToLessHHIncome;
    }

    public String getCostFor30kToLessHHIncome() {
        return costFor30kToLessHHIncome;
    }

    public void setOffersCredits(String offersCredits) {
        this.offersCredits = offersCredits;
    }

    public String getOffersCredits() {
        return offersCredits;
    }

    public void setOffersAdvancedPlacements(String offersAdvancedPlacements) {
        this.offersAdvancedPlacements = offersAdvancedPlacements;
    }

    public String getOffersAdvancedPlacements() {
        return offersAdvancedPlacements;
    }

    public void setStudentFacultyRatio(String studentFacultyRatio) {
        this.studentFacultyRatio = studentFacultyRatio;
    }

    public String getStudentFacultyRatio() {
        return studentFacultyRatio;
    }

    public void setMajorsAvailable(String majorsAvailable) {
        this.majorsAvailable = majorsAvailable;
    }

    public String getMajorsAvailable() {
        return majorsAvailable;
    }

    public void setRetentionRate(String retentionRate) {
        this.retentionRate = retentionRate;
    }

    public String getRetentionRate() {
        return retentionRate;
    }
   
    public void setRegularAppDue(String regularAppDue) {
        this.regularAppDue = regularAppDue;
    }
    
    public String getRegularAppDue() {
        return regularAppDue;
    }
    
    public void setEarlyDecisionAppDue(String earlyDecisionAppDue) {
        this.earlyDecisionAppDue = earlyDecisionAppDue;
    }
    
    public String getEarlyDecisionAppDue() {
        return earlyDecisionAppDue;
    }

    public void setEarlyActionAppDue(String earlyActionAppDue) {
        this.earlyActionAppDue = earlyActionAppDue;
    }

    public String getEarlyActionAppDue() {
        return earlyActionAppDue;
    }

    public void setUrlUniverWebSite(String urlUniverWebSite) {
        this.urlUniverWebSite = urlUniverWebSite;
    }

    public String getUrlUniverWebSite() {
        return urlUniverWebSite;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


    public void setSatTotalRange(String satTotalRange) {
        this.satTotalRange = satTotalRange;
    }

    public String getSatTotalRange() {
        return satTotalRange;
    }

    public void setSatReadingRange(String satReadingRange) {
        this.satReadingRange = satReadingRange;
    }

    public String getSatReadingRange() {
        return satReadingRange;
    }

    public void setSatMathRange(String satMathRange) {
        this.satMathRange = satMathRange;
    }

    public String getSatMathRange() {
        return satMathRange;
    }

    public void setAcceptanceRate(String acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public String getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setTotalApplicants(String totalApplicants) {
        this.totalApplicants = totalApplicants;
    }

    public String getTotalApplicants() {
        return totalApplicants;
    }

    public void setAdmittedAppl(String admittedAppl) {
        this.admittedAppl = admittedAppl;
    }

    public String getAdmittedAppl() {
        return admittedAppl;
    }

    public void setEnrolledAppl(String enrolledAppl) {
        this.enrolledAppl = enrolledAppl;
    }

    public String getEnrolledAppl() {
        return enrolledAppl;
    }

    public void setApplFee(String applFee) {
        this.applFee = applFee;
    }

    public String getApplFee() {
        return applFee;
    }

    public void setRegApplDate(String regApplDate) {
        this.regApplDate = regApplDate;
    }

    public String getRegApplDate() {
        return regApplDate;
    }

    public void setStudentsReceivFinAid(String studentsReceivFinAid) {
        this.studentsReceivFinAid = studentsReceivFinAid;
    }

    public String getStudentsReceivFinAid() {
        return studentsReceivFinAid;
    }

    public void setCostInState(String costInState) {
        this.costInState = costInState;
    }

    public String getCostInState() {
        return costInState;
    }

    public void setCostOutOfState(String costOutOfState) {
        this.costOutOfState = costOutOfState;
    }

    public String getCostOutOfState() {
        return costOutOfState;
    }

    public void setCostFor110kHHIncome(String costFor110kHHIncome) {
        this.costFor110kHHIncome = costFor110kHHIncome;
    }

    public String getCostFor110kHHIncome() {
        return costFor110kHHIncome;
    }

    public void setCostHousing(String costHousing) {
        this.costHousing = costHousing;
    }

    public String getCostHousing() {
        return costHousing;
    }

    public void setCostBooksSuppl(String costBooksSuppl) {
        this.costBooksSuppl = costBooksSuppl;
    }

    public String getCostBooksSuppl() {
        return costBooksSuppl;
    }

    public void setCostTransportation(String costTransportation) {
        this.costTransportation = costTransportation;
    }

    public String getCostTransportation() {
        return costTransportation;
    }

    public void setUnderGradStudents(String underGradStudents) {
        this.underGradStudents = underGradStudents;
    }

    public String getUnderGradStudents() {
        return underGradStudents;
    }
    private List<String> raceProfile;
    private List<String> avrgNetPriceByHHincom;

    public void setRaceProfile(List<String> raceProfile) {
        this.raceProfile = raceProfile;
    }
    public List<String> getRaceProfile() {
        return raceProfile;
    }
    public void setAvrgNetPriceByHHincom(List<String> avrgNetPriceByHHincom) {
        this.avrgNetPriceByHHincom = avrgNetPriceByHHincom;
    }

    public List<String> getAvrgNetPriceByHHincom() {
        return avrgNetPriceByHHincom;
    }

    public void setUrlCollegeBoard(String urlCollegeBoard) {
        this.urlCollegeBoard = urlCollegeBoard;
    }
    
    public String getUrlCollegeBoard() {
        return urlCollegeBoard;
    }
    
    public void setUniverName(String univerName) {
        this.univerName = univerName;
    }
    
    public String getUniverName() {
        return univerName;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    public void setMapLink(String mapLink) {
        this.mapLink = mapLink;
    }

    public String getMapLink() {
        return mapLink;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
    public void setSchoolTypeByYears(String schoolTypeByYears) {
        this.schoolTypeByYears = schoolTypeByYears;
    }
    
    public String getSchoolTypeByYears() {
        return schoolTypeByYears;
    }
    
    public void setSchoolTypeByDesignation(String schoolTypeByDesignation) {
        this.schoolTypeByDesignation = schoolTypeByDesignation;
    }
    
    public String getSchoolTypeByDesignation() {
        return schoolTypeByDesignation;
    }
    
    public void setSchoolSize(String schoolSize) {
        this.schoolSize = schoolSize;
    }
    
    public String getSchoolSize() {
        return schoolSize;
    }
    
    public void setSchoolSetting(String schoolSetting) {
        this.schoolSetting = schoolSetting;
    }
    
    public String getSchoolSetting() {
        return schoolSetting;
    }
    
    public void setGraduationRate(String graduationRate) {
        this.graduationRate = graduationRate;
    }
    
    public String getGraduationRate() {
        return graduationRate;
    }
    
    public void setSatScoreRange(String satScoreRange) {
        this.satScoreRange = satScoreRange;
    }
    
    public String getSatScoreRange() {
        return satScoreRange;
    }
    public University(String urlCollegeBoard, String univerName, String address, String schoolTypeByYears, String schoolTypeByDesignation, String schoolSize, String schoolSetting, String graduationRate, String satScoreRange) {
    this.urlCollegeBoard = urlCollegeBoard;
    this.univerName = univerName;
    this.address = address;
    this.schoolTypeByYears = schoolTypeByYears;
    this.schoolTypeByDesignation = schoolTypeByDesignation;
    this.schoolSize = schoolSize;
    this.schoolSetting = schoolSetting;
    this.graduationRate = graduationRate;
    this.satScoreRange = satScoreRange;
    }

    public University() {
        //TODO Auto-generated constructor stub
    }

  
}
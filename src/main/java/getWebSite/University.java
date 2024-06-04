package getWebSite;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class University {
// search page data
    public String univerName; // College Board
    private String univerURLfriendly; // url for spreashees: univerName + university admissions page
    private String city; // College Board
    private String state; // College Board
    private String schoolTypeByYears; // College Board
    private String schoolTypeByDesignation; // College Board
    private String schoolSize; // College Board
    private String schoolSetting; // College Board
    private String graduationRate; // College Board
    private String satScoreRange; // College Board
    private String urlCollegeBoard; // College Board
    private String urlCBfriendly; // url for spreashees, combines collegeBoardCode + urlCollegeBoard
// Overview page data
    private String address; // College Board
    private String mapLink; // College Board
    private String urlMapLinkFriendly; // url for spreashees, combines "Map" and direct URL
    private String phone; // College Board
    private String collegeBoardCode; // College Board
    private String url_univerOnlineApplication; // College Board
// Admissions page data
    private String urlUniverWebSite; // College Board
    private String acceptanceRate; // College Board
    private String totalApplicants; // College Board
    private String admittedAppl; // College Board
    private String enrolledAppl; // College Board
    private String satTotalRange; // College Board
    private String satReadingRange; // College Board
    private String satMathRange; // College Board
    private String applFee; // College Board
    private String regularAppDue; // College Board
    private String earlyDecisionAppDue; // NOT implemented ----!!!!!!!!
    private String earlyActionAppDue; // NOT implemented-----!!!!!!!!!
    // GPA data
    // Offers placement into advanced courses - list of courses https://bigfuture.collegeboard.org/colleges/california-state-university-sacramento/academics
    // "Special Academics Programs" - list of programs like "Double Major" "Distance Learning" "Student-Designed Major" "Undergraduate Research" etc.
// Academics page data
    private String studentFacultyRatio; // College Board
    private String majorsCount; // College Board
    private String retentionRate; // College Board
    private List<String> majorsAvailable; // College Board
    private String offersCredits; // College Board
    private String offersAdvancedPlacements; // College Board
// Costs page data
    private String costAvrgPerYearAfterAid; // College Board
    private String studentsReceivFinAid; // College Board
    private String avrgAidPackage; // College Board
    private String costInStateFull; // College Board
    private String costOutOfStateFull; // College Board
    private String costFor110kHHIncome; // College Board
    private String costHousing;  // College Board
    private String costBooksSuppl; // College Board
    private String costPersonalExpenses; // College Board
    private String costTransportation; // College Board
// Campus Life page data
    private String underGradStudents; // College Board
    private String graduateStudents; // College Board
    private String fullTimeStudents; // College Board
    private String partTimeStudents; // College Board
    private String firstYearsInCollegeHousing; // College Board
    private String priRes_OutState; // College Board
    private String ethn_black; // College Board
    private String ethn_asians; // College Board
    private String ethn_hispanics; // College Board
    private String ethn_multi; // College Board
    private String ethn_nativAm; // College Board
    private String ethn_pacificIslr; // College Board
    private String ethn_white; // College Board
    private String ethn_intenational; // College Board
    private String ethn_unknown; // College Board
// -- My fields
    // Applying (yes/no/interested)
    // Priority of interest
// SCOIR data
    // Nearest Airport
    // Academics -  Popular Majors
    // Academics -  Applications Deadlines
    // Stidemtslife  - gender
    // ROTC Program?
    // SCOIR ID 
    // Application method

//Common App data https://www.commonapp.org/explore/
    private String commonAppID;
    // Common App ID
    // Common App URL
    // Admissions website
    // Financial aid website
    // Addmissions email admissions@nyu.edu
    //Application Deadlines // First Year
    //  Restrictive Early Action - 11/01/2023
    //Regular Decision - 01/03/2024
    // Links: College WebsiteAdmissions OfficeVirtual TourCollege Navigator
    // other deadlines: Visit our website
    
    
    public Field[] getFields() {
        return University.class.getDeclaredFields();
    }

    public String getUrl_univerOnlineApplication() {
        return url_univerOnlineApplication;
    }

    public void setUrl_univerOnlineApplication(String url_univerOnlineApplication) {
        this.url_univerOnlineApplication = url_univerOnlineApplication;
    }

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

    public void setRetentionRate(String retentionRate) {
        this.retentionRate = retentionRate;
    }
    public String getRetentionRate() {
        return retentionRate;
    }

    public void addMajorAvailable(String major) {
        if (majorsAvailable == null) {
            majorsAvailable = new ArrayList<>();
        }
        majorsAvailable.add(major);
    }

    public String getMajorsAvailable() {
        return String.join("\n", majorsAvailable); // Convert the List to a newline-separated string
    }

    public void setMajorsAvailable(List<String> majorsAvailable) { // Update the parameter type to List<String>
        this.majorsAvailable = majorsAvailable;
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

    public void setStudentsReceivFinAid(String studentsReceivFinAid) {
        this.studentsReceivFinAid = studentsReceivFinAid;
    }

    public String getStudentsReceivFinAid() {
        return studentsReceivFinAid;
    }

    public void setcostInStateFull(String costInStateFull) {
        this.costInStateFull = costInStateFull;
    }

    public String getcostInStateFull() {
        return costInStateFull;
    }

    public void setcostOutOfStateFull(String costOutOfStateFull) {
        this.costOutOfStateFull = costOutOfStateFull;
    }

    public String getcostOutOfStateFull() {
        return costOutOfStateFull;
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
    public University() {
        //TODO Auto-generated constructor stub
    }

    public void setMajorsCount(String majorsCount) {
        this.majorsCount = majorsCount;
    }

    public String getMajorsCount() {
        return majorsCount;
    }

    public void setCollegeBoardCode(String collegeBoardCode) {
        this.collegeBoardCode = collegeBoardCode;
    }

    public String getCollegeBoardCode() {
        return collegeBoardCode;
    }

    public void setFirstYearsInCollegeHousing(String firstYearsInCollegeHousing) {
        this.firstYearsInCollegeHousing = firstYearsInCollegeHousing;
    }

    public String getFirstYearsInCollegeHousing() {
        return firstYearsInCollegeHousing;
    }

    public String getCostInStateFull() {
        return costInStateFull;
    }

    public void setCostInStateFull(String costInStateFull) {
        this.costInStateFull = costInStateFull;
    }

    public String getCostOutOfStateFull() {
        return costOutOfStateFull;
    }

    public void setCostOutOfStateFull(String costOutOfStateFull) {
        this.costOutOfStateFull = costOutOfStateFull;
    }

    public String getGraduateStudents() {
        return graduateStudents;
    }

    public void setGraduateStudents(String graduateStudents) {
        this.graduateStudents = graduateStudents;
    }

    public String getFullTimeStudents() {
        return fullTimeStudents;
    }

    public void setFullTimeStudents(String fullTimeStudents) {
        this.fullTimeStudents = fullTimeStudents;
    }

    public String getPartTimeStudents() {
        return partTimeStudents;
    }

    public void setPartTimeStudents(String partTimeStudents) {
        this.partTimeStudents = partTimeStudents;
    }

    public String getPriRes_OutState() {
        return priRes_OutState;
    }

    public void setPriRes_OutState(String priRes_OutState) {
        this.priRes_OutState = priRes_OutState;
    }

    public String getEthn_black() {
        return ethn_black;
    }

    public void setEthn_black(String ethn_black) {
        this.ethn_black = ethn_black;
    }

    public String getEthn_asians() {
        return ethn_asians;
    }

    public void setEthn_asians(String ethn_asians) {
        this.ethn_asians = ethn_asians;
    }

    public String getEthn_hispanics() {
        return ethn_hispanics;
    }

    public void setEthn_hispanics(String ethn_hispanics) {
        this.ethn_hispanics = ethn_hispanics;
    }

    public String getEthn_multi() {
        return ethn_multi;
    }

    public void setEthn_multi(String ethn_multi) {
        this.ethn_multi = ethn_multi;
    }

    public String getEthn_nativAm() {
        return ethn_nativAm;
    }

    public void setEthn_nativAm(String ethn_nativAm) {
        this.ethn_nativAm = ethn_nativAm;
    }

    public String getEthn_pacificIslr() {
        return ethn_pacificIslr;
    }

    public void setEthn_pacificIslr(String ethn_pacificIslr) {
        this.ethn_pacificIslr = ethn_pacificIslr;
    }

    public String getEthn_white() {
        return ethn_white;
    }

    public void setEthn_white(String ethn_white) {
        this.ethn_white = ethn_white;
    }

    public String getEthn_intenational() {
        return ethn_intenational;
    }

    public void setEthn_intenational(String ethn_intenational) {
        this.ethn_intenational = ethn_intenational;
    }

    public String getEthn_unknown() {
        return ethn_unknown;
    }

    public void setEthn_unknown(String ethn_unknown) {
        this.ethn_unknown = ethn_unknown;
    }

    public String getCostPersonalExpenses() {
        return costPersonalExpenses;
    }

    public void setCostPersonalExpenses(String costPersonalExpenses) {
        this.costPersonalExpenses = costPersonalExpenses;
    }
  }
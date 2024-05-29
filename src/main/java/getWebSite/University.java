package getWebSite;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class University {
// search page data
    private String univerName;
    private String city;
    private String state;
    private String schoolTypeByYears;
    private String schoolTypeByDesignation;
    private String schoolSize;
    private String schoolSetting;
    private String graduationRate;
    private String satScoreRange;
    private String urlCollegeBoard;
// Overview page data
    private String address;
    private String mapLink;
    private String phone;
    private String collegeBoardCode;
// Admissions page data
    private String urlUniverWebSite;
    private String acceptanceRate;
    private String totalApplicants;
    private String admittedAppl;
    private String enrolledAppl;
    private String satTotalRange;
    private String satReadingRange;
    private String satMathRange;
    private String applFee;
    private String regularAppDue; // NOT implemented
    private String earlyDecisionAppDue; // NOT implemented
    private String earlyActionAppDue; // NOT implemented
    // GPA data
    // Offers placement into advanced courses - list of courses
// Academics page data
    private String studentFacultyRatio;
    private String majorsCount;
    private String retentionRate;
    private List<String> majorsAvailable;
    private String offersCredits;
    private String offersAdvancedPlacements;
// Costs page data
    private String costAvrgPerYearAfterAid;
    private String studentsReceivFinAid;
    private String avrgAidPackage;
    private String costInStateFull;
    private String costOutOfStateFull;
    private String costFor110kHHIncome;
    private String costHousing; 
    private String costBooksSuppl;
    private String costPersonalExpenses;
    private String costTransportation;
// Campus Life page data
    private String url_univerOnlineApplication;
    private String underGradStudents;
    private String graduateStudents;
    private String fullTimeStudents;
    private String partTimeStudents;
    private String firstYearsInCollegeHousing;
    private String priRes_OutState;
    private String ethn_black;
    private String ethn_asians;
    private String ethn_hispanics;
    private String ethn_multi;
    private String ethn_nativAm;
    private String ethn_pacificIslr;
    private String ethn_white;
    private String ethn_intenational;
    private String ethn_unknown;


    public void writeToFileTXT(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            StringBuilder sb = new StringBuilder();
            String delim = "|";
            // Append the data for each university
            //sb.append((countOfUnivrFound - udInx) + " of " + countOfUnivrFound);
            sb.append(delim);
            //sb.append(universityData[udInx].getUniverName());
            sb.append('\n');
            writer.append(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
package dataObjects;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class University {
// search page data
    private String UniverName; // College Board
    private String City; // College Board
    private String State; // College Board
    private String UniverTypeByYears; // College Board
    private String UniverTypeByDesignation; // College Board
    private String UniverSize; // College Board
    private String UniverSetting; // College Board
    private String GraduationRate; // College Board
    private String SATScoreRange; // College Board
    private String URLCollegeBoard; // College Board
// Overview page data
    private String Address; // College Board
    private String Phone; // College Board
    private String CollegeBoardCode; // College Board
    private String UniverOnlineApplicationURL; // College Board
// Admissions page data
    private String AcceptanceRate; // College Board
    private String ApplicantsTotal; // College Board
    private String ApplicantsAdmitted; // College Board
    private String ApplicantsEnrolled; // College Board
    private String SATTotalRange; // College Board
    private String SATReadingRange; // College Board
    private String SATMathRange; // College Board
    private String ApplicationFee; // College Board
    private String RegularAppDueDate; // College Board
    private String EarlyDecisionAppDueDate; // NOT implemented ----!!!!!!!!
    private String EarlyActionAppDueDate; // NOT implemented-----!!!!!!!!!
    // GPA data
    // Offers placement into advanced courses - list of courses https://bigfuture.collegeboard.org/colleges/california-State-university-sacramento/academics
    // "Special Academics Programs" - list of programs like "Double Major" "Distance Learning" "Student-Designed Major" "Undergraduate Research" etc.
// Academics page data
    private String StudentFacultyRatio; // College Board
    private String RetentionRate; // College Board
    private String MajorsCount; // College Board
    private String MyMajorsCount; // calculated string from MajorsAvailable
    private List<String> MajorsAvailable = new ArrayList<>(); // College Board
    //private List<String> MyMajorsAvailable ; // subset of majors of interest from MajorsAvailable list
    private List<String> MyMajorsAvailable = new ArrayList<>(); // subset of majors of interest from MajorsAvailable list
    private String OffersCredits; // College Board
    private String OffersAdvancedPlacements; // College Board
// Costs page data
    private String CostAvrgPerYearAfterAid; // College Board
    private String StudentsReceivFinAid; // College Board
    private String AvrgAidPackage; // College Board
    private String CostInStateFull; // College Board
    private String CostOutOfStateFull; // College Board
    private String CostFor110kHHIncome; // College Board
    private String CostHousing;  // College Board
    private String CostBooksSuppl; // College Board
    private String CostPersonalExpenses; // College Board
    private String CostTransportation; // College Board
// Campus Life page data
    private String UnderGradStudents; // College Board
    private String GraduateStudents; // College Board
    private String FullTimeStudents; // College Board
    private String PartTimeStudents; // College Board
    private String FirstYearsInCollegeHousing; // College Board
    private String PrimaryResidenceOutOfState; // College Board
    private String Ethn_black; // College Board
    private String Ethn_asians; // College Board
    private String Ethn_hispanics; // College Board
    private String Ethn_multi; // College Board
    private String Ethn_nativAm; // College Board
    private String Ethn_pacificIslr; // College Board
    private String Ethn_white; // College Board
    private String Ethn_intenational; // College Board
    private String Ethn_unknown; // College Board
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
    private String CommonAppID;
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
    
    public University() {
        //TODO Auto-generated constructor stub
    }
    
    public University(String universityName, String URLCollegeBoard) {
        this.UniverName = universityName;
        this.URLCollegeBoard = URLCollegeBoard;
    }

    public Field[] getFields() {
        return University.class.getDeclaredFields();
    }

    public String getUniverOnlineApplicationURL() {
        return UniverOnlineApplicationURL != null ? UniverOnlineApplicationURL : "";
    }

    public void setUniverOnlineApplicationURL(String UniverOnlineApplicationURL) {
        this.UniverOnlineApplicationURL = UniverOnlineApplicationURL;
    }

    public void setCostAvrgPerYearAfterAid(String CostAvrgPerYearAfterAid) {
        this.CostAvrgPerYearAfterAid = CostAvrgPerYearAfterAid;
    }

    public String getCostAvrgPerYearAfterAid() {
        return CostAvrgPerYearAfterAid != null ? CostAvrgPerYearAfterAid : "";
    }

    public void setAvrgAidPackage(String AvrgAidPackage) {
        this.AvrgAidPackage = AvrgAidPackage;
    }

    public String getAvrgAidPackage() {
        return AvrgAidPackage != null ? AvrgAidPackage : "";
    }
   
    public void setOffersCredits(String OffersCredits) {
        this.OffersCredits = OffersCredits;
    }

    public String getOffersCredits() {
        return OffersCredits != null ? OffersCredits : "";
    }

    public void setOffersAdvancedPlacements(String OffersAdvancedPlacements) {
        this.OffersAdvancedPlacements = OffersAdvancedPlacements;
    }

    public String getOffersAdvancedPlacements() {
        return OffersAdvancedPlacements != null ? OffersAdvancedPlacements : "";
    }

    public void setStudentFacultyRatio(String StudentFacultyRatio) {
        this.StudentFacultyRatio = StudentFacultyRatio;
    }
    public String getStudentFacultyRatio() {
        return StudentFacultyRatio != null ? StudentFacultyRatio : "";
    }

    public void setRetentionRate(String RetentionRate) {
        this.RetentionRate = RetentionRate;
    }
    public String getRetentionRate() {
        return RetentionRate != null ? RetentionRate : "";
    }
    public String getMyMajorsAvailable() {
        return MyMajorsAvailable != null ? String.join("\n", MyMajorsAvailable) : ""; // Convert the List to a newline-separated string
    }

    public void setMyMajorsAvailable(List<String> majorKeywords) {
        if (!this.MajorsAvailable.isEmpty()){
        for (String major : this.MajorsAvailable) {
            for (String keyword : majorKeywords) {
                if (major.toLowerCase().contains(keyword.toLowerCase())) {
                    if (this.MyMajorsAvailable == null) {
                        this.MyMajorsAvailable = new ArrayList<>();
                    }
                // Check if the major is already in my majors list
                if (!this.MyMajorsAvailable.isEmpty() ) {
                    for (String myMajor : this.MyMajorsAvailable) {
                        if (myMajor.toLowerCase().equals(major.toLowerCase())){
                            //System.out.println("University: Major " + major + " is already in my majors list!");
                        } else {
                            this.MyMajorsAvailable.add(major);
                            //System.out.println("University: Major " + major + " added to my majors list!");
                            break;
                        }
                    }
                } else {
                    this.MyMajorsAvailable.add(major);
                    //System.out.println("University: Major " + major + " added to my majors list!");
                    break;
                }
                }
            }
        }
        }
            // Update the count of my majors
            try {
            this.MyMajorsCount = Integer.toString(this.MyMajorsAvailable.size());
            } catch (Exception e) {
                //System.out.println("University: Unable to set MyMajorsCount!");
                this.MyMajorsCount = "0";
            }
            System.out.println("University: MyMajorsCount: " + this.MyMajorsCount);
    }
    public void addMajorAvailable(String major) {
        if (MajorsAvailable == null) {
            MajorsAvailable = new ArrayList<>();
        }
        MajorsAvailable.add(major);
    }

    public String getMajorsAvailable() {
        return MajorsAvailable != null ? String.join("\n", MajorsAvailable) : ""; // Convert the List to a newline-separated string
    }

    public void setMajorsAvailable(List<String> MajorsAvailable) { // Update the parameter type to List<String>
        this.MajorsAvailable = MajorsAvailable;
    }
    public void setMajorsCount(String MajorsCount) {
        this.MajorsCount = MajorsCount;
    }

    public String getMajorsCount() {
        return MajorsCount != null ? MajorsCount : "";
    }

    public String getMyMajorsCount() {
        return MyMajorsCount != null ? MyMajorsCount : "";
    }
    public void setRegularAppDueDate(String RegularAppDueDate) {
        this.RegularAppDueDate = RegularAppDueDate;
    }
    
    public String getRegularAppDueDate() {
        return RegularAppDueDate != null ? RegularAppDueDate : "";
    }
    
    public void setEarlyDecisionAppDueDate(String EarlyDecisionAppDueDate) {
        this.EarlyDecisionAppDueDate = EarlyDecisionAppDueDate;
    }
    
    public String getEarlyDecisionAppDueDate() {
        return EarlyDecisionAppDueDate != null ? EarlyDecisionAppDueDate : "";
    }

    public void setEarlyActionAppDueDate(String EarlyActionAppDueDate) {
        this.EarlyActionAppDueDate = EarlyActionAppDueDate;
    }

    public String getEarlyActionAppDueDate() {
        return EarlyActionAppDueDate != null ? EarlyActionAppDueDate : "";
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPhone() {
        return Phone != null ? Phone : "";
    }


    public void setSATTotalRange(String SATTotalRange) {
        this.SATTotalRange = SATTotalRange;
    }

    public String getSATTotalRange() {
        return SATTotalRange != null ? SATTotalRange : "";
    }

    public void setSATReadingRange(String SATReadingRange) {
        this.SATReadingRange = SATReadingRange;
    }

    public String getSATReadingRange() {
        return SATReadingRange != null ? SATReadingRange : "";
    }

    public void setSATMathRange(String SATMathRange) {
        this.SATMathRange = SATMathRange;
    }

    public String getSATMathRange() {
        return SATMathRange != null ? SATMathRange : "";
    }

    public void setAcceptanceRate(String AcceptanceRate) {
        this.AcceptanceRate = AcceptanceRate;
    }

    public String getAcceptanceRate() {
        return AcceptanceRate != null ? AcceptanceRate : "";
    }

    public void setApplicantsTotal(String ApplicantsTotal) {
        this.ApplicantsTotal = ApplicantsTotal;
    }

    public String getApplicantsTotal() {
        return ApplicantsTotal != null ? ApplicantsTotal : "";
    }

    public void setApplicantsAdmitted(String ApplicantsAdmitted) {
        this.ApplicantsAdmitted = ApplicantsAdmitted;
    }

    public String getApplicantsAdmitted() {
        return ApplicantsAdmitted != null ? ApplicantsAdmitted : "";
    }

    public void setApplicantsEnrolled(String ApplicantsEnrolled) {
        this.ApplicantsEnrolled = ApplicantsEnrolled;
    }

    public String getApplicantsEnrolled() {
        return ApplicantsEnrolled != null ? ApplicantsEnrolled : "";
    }

    public void setApplicationFee(String ApplicationFee) {
        this.ApplicationFee = ApplicationFee;
    }

    public String getApplicationFee() {
        return ApplicationFee != null ? ApplicationFee : "";
    }

    public void setStudentsReceivFinAid(String StudentsReceivFinAid) {
        this.StudentsReceivFinAid = StudentsReceivFinAid;
    }

    public String getStudentsReceivFinAid() {
        return StudentsReceivFinAid != null ? StudentsReceivFinAid : "";
    }

    public void setCostInStateFull(String CostInStateFull) {
        this.CostInStateFull = CostInStateFull;
    }

    public String getCostInStateFull() {
        return CostInStateFull != null ? CostInStateFull : "";
    }

    public void setCostOutOfStateFull(String CostOutOfStateFull) {
        this.CostOutOfStateFull = CostOutOfStateFull;
    }

    public String getCostOutOfStateFull() {
        return CostOutOfStateFull != null ? CostOutOfStateFull : "";
    }

    public void setCostFor110kHHIncome(String CostFor110kHHIncome) {
        this.CostFor110kHHIncome = CostFor110kHHIncome;
    }

    public String getCostFor110kHHIncome() {
        return CostFor110kHHIncome != null ? CostFor110kHHIncome : "";
    }

    public void setCostHousing(String CostHousing) {
        this.CostHousing = CostHousing;
    }

    public String getCostHousing() {
        return CostHousing != null ? CostHousing : "";
    }

    public void setCostBooksSuppl(String CostBooksSuppl) {
        this.CostBooksSuppl = CostBooksSuppl;
    }

    public String getCostBooksSuppl() {
        return CostBooksSuppl != null ? CostBooksSuppl : "";
    }

    public void setCostTransportation(String CostTransportation) {
        this.CostTransportation = CostTransportation;
    }

    public String getCostTransportation() {
        return CostTransportation != null ? CostTransportation : "";
    }

    public void setUnderGradStudents(String UnderGradStudents) {
        this.UnderGradStudents = UnderGradStudents;
    }

    public String getUnderGradStudents() {
        return UnderGradStudents != null ? UnderGradStudents : "";
    }

    public void setURLCollegeBoard(String URLCollegeBoard) {
        this.URLCollegeBoard = URLCollegeBoard;
    }
    
    public String getURLCollegeBoard() {
        return URLCollegeBoard != null ? URLCollegeBoard : "";
    }
    
    public void setUniverName(String UniverName) {
        this.UniverName = UniverName;
    }
    
    public String getUniverName() {
        return UniverName != null ? UniverName : "";
    }
    
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public String getAddress() {
        return Address != null ? Address : "";
    }
   
    public void setCity(String City) {
        this.City = City;
    }

    public String getCity() {
        return City != null ? City : "";
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getState() {
        return State != null ? State : "";
    }
    public void setUniverTypeByYears(String UniverTypeByYears) {
        this.UniverTypeByYears = UniverTypeByYears;
    }
    
    public String getUniverTypeByYears() {
        return UniverTypeByYears != null ? UniverTypeByYears : "";
    }
    
    public void setUniverTypeByDesignation(String UniverTypeByDesignation) {
        this.UniverTypeByDesignation = UniverTypeByDesignation;
    }
    
    public String getUniverTypeByDesignation() {
        return UniverTypeByDesignation != null ? UniverTypeByDesignation : "";
    }
    
    public void setUniverSize(String UniverSize) {
        this.UniverSize = UniverSize;
    }
    
    public String getUniverSize() {
        return UniverSize != null ? UniverSize : "";
    }
    
    public void setUniverSetting(String UniverSetting) {
        this.UniverSetting = UniverSetting;
    }
    
    public String getUniverSetting() {
        return UniverSetting != null ? UniverSetting : "";
    }
    
    public void setGraduationRate(String GraduationRate) {
        this.GraduationRate = GraduationRate;
    }
    
    public String getGraduationRate() {
        return GraduationRate != null ? GraduationRate : "";
    }
    
    public void setSATScoreRange(String SATScoreRange) {
        this.SATScoreRange = SATScoreRange;
    }
    
    public String getSATScoreRange() {
        return SATScoreRange != null ? SATScoreRange : "";
    }

    public void setCollegeBoardCode(String CollegeBoardCode) {
        this.CollegeBoardCode = CollegeBoardCode;
    }

    public String getCollegeBoardCode() {
        return CollegeBoardCode != null ? CollegeBoardCode : "";
    }

    public void setFirstYearsInCollegeHousing(String FirstYearsInCollegeHousing) {
        this.FirstYearsInCollegeHousing = FirstYearsInCollegeHousing;
    }

    public String getFirstYearsInCollegeHousing() {
        return FirstYearsInCollegeHousing != null ? FirstYearsInCollegeHousing : "";
    }

    public String getGraduateStudents() {
        return GraduateStudents != null ? GraduateStudents : "";
    }

    public void setGraduateStudents(String GraduateStudents) {
        this.GraduateStudents = GraduateStudents;
    }

    public String getFullTimeStudents() {
        return FullTimeStudents != null ? FullTimeStudents : "";
    }

    public void setFullTimeStudents(String FullTimeStudents) {
        this.FullTimeStudents = FullTimeStudents;
    }

    public String getPartTimeStudents() {
        return PartTimeStudents != null ? PartTimeStudents : "";
    }

    public void setPartTimeStudents(String PartTimeStudents) {
        this.PartTimeStudents = PartTimeStudents;
    }

    public String getPrimaryResidenceOutOfState() {
        return PrimaryResidenceOutOfState != null ? PrimaryResidenceOutOfState : "";
    }

    public void setPrimaryResidenceOutOfState(String PrimaryResidenceOutOfState) {
        this.PrimaryResidenceOutOfState = PrimaryResidenceOutOfState;
    }

    public String getEthn_black() {
        return Ethn_black != null ? Ethn_black : "";
    }

    public void setEthn_black(String Ethn_black) {
        this.Ethn_black = Ethn_black;
    }

    public String getEthn_asians() {
        return Ethn_asians != null ? Ethn_asians : "";
    }

    public void setEthn_asians(String Ethn_asians) {
        this.Ethn_asians = Ethn_asians;
    }

    public String getEthn_hispanics() {
        return Ethn_hispanics != null ? Ethn_hispanics : "";
    }

    public void setEthn_hispanics(String Ethn_hispanics) {
        this.Ethn_hispanics = Ethn_hispanics;
    }

    public String getEthn_multi() {
        return Ethn_multi != null ? Ethn_multi : "";
    }

    public void setEthn_multi(String Ethn_multi) {
        this.Ethn_multi = Ethn_multi;
    }

    public String getEthn_nativAm() {
        return Ethn_nativAm != null ? Ethn_nativAm : "";
    }

    public void setEthn_nativAm(String Ethn_nativAm) {
        this.Ethn_nativAm = Ethn_nativAm;
    }

    public String getEthn_pacificIslr() {
        return Ethn_pacificIslr != null ? Ethn_pacificIslr : "";
    }

    public void setEthn_pacificIslr(String Ethn_pacificIslr) {
        this.Ethn_pacificIslr = Ethn_pacificIslr;
    }

    public String getEthn_white() {
        return Ethn_white != null ? Ethn_white : "";
    }

    public void setEthn_white(String Ethn_white) {
        this.Ethn_white = Ethn_white;
    }

    public String getEthn_intenational() {
        return Ethn_intenational != null ? Ethn_intenational : "";
    }

    public void setEthn_intenational(String Ethn_intenational) {
        this.Ethn_intenational = Ethn_intenational;
    }

    public String getEthn_unknown() {
        return Ethn_unknown != null ? Ethn_unknown : "";
    }

    public void setEthn_unknown(String Ethn_unknown) {
        this.Ethn_unknown = Ethn_unknown;
    }

    public String getCostPersonalExpenses() {
        return CostPersonalExpenses != null ? CostPersonalExpenses : "";
    }

    public void setCostPersonalExpenses(String CostPersonalExpenses) {
        this.CostPersonalExpenses = CostPersonalExpenses;
    }
  }
package cn.guanxiaoda.web.home.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "resume_coll")
public class Resume {

    /**
     * skillsHeading : Custom Skills Heading
     * jobWorkHeading : Custom Wowellrk Heading
     * accomplishmentsHeading : Custom Accomplishments Heading
     * projectsHeading : Custom Projects Heading
     * hobbiesHeading : Custom Hobbies Heading
     * person : {"name":"Bob","email":"johndoe@gmail.com","address":"7 Java Drive, OOP City","phoneNumber":"+1(334)567-2346","jobTitle":"Software Engineer","website":"https://www.google.com","objective":"Bleh bleh bleh bleh bleh bleh bleh bleh"}
     * skills : ["Java","C++","Android"]
     * accomplishments : ["I did something remarkable.","I did something else remarkable."]
     * jobWork : [{"company":"Example Ltd.","position":"Software Engineer","summary":"At Example Ltd., I did such and such and such and such and such and such and such and such and such.","startDate":"August 19, 1997","endDate":"August 19, 2001","highlights":["Worked on such and such","I did such and such and such and such and such and such and such and such and such. I did such and such and such and such and such and such and such and such and such.","Also worked on this"],"keywords":["java","c++"]},{"company":"Example Ltd.2","position":"Software Engineer","summary":"At Example Ltd.2, I did such and such and such and such and such and such and such and such and such.","startDate":"August 19, 1997","endDate":"August 19, 2001","highlights":["Worked on such and such","Also worked on this"],"keywords":["java","c++"]}]
     * volunteerWork : [{"company":"Example Institution","position":"Volunteer","summary":"At Example Institution, I did such and such.","startDate":"August 19, 1997","endDate":"August 19, 2001","highlights":["Worked on such and such","Also worked on this"],"keywords":["java","c++"]},{"company":"Example Institution2","position":"Volunteer","summary":"At Example Institution2, I did such and such.","startDate":"August 19, 1997","endDate":"August 19, 2001","highlights":["Worked on such and such","Also worked on this"],"keywords":["java","c++"]}]
     * projects : [{"name":"AwesomeProject","description":"This awesome project is awesome!","highlights":["Does such and such.","And it does such and such."],"keywords":["java","c++"],"url":"https://www.github.com"},{"name":"AwesomeProject2","description":"This awesome project2 is awesome!","highlights":["Does such and such.","And it does such and such."],"keywords":["java","c++"],"url":"https://www.github.com"}]
     * education : {"schools":[{"name":"Ardenne High School","startDate":"100AD","endDate":"104AD","summary":"Some summary!","gpa":"5.0"}],"examinations":[{"name":"CSEC","startDate":"104AD","subjects":[{"name":"Math","result":"100"},{"name":"English","result":"100"}]}]}
     * hobbies : ["Programming","Video editing","Gaming"]
     */

    @Id
    private String name;
    private String skillsHeading;
    private String jobWorkHeading;
    private String accomplishmentsHeading;
    private String projectsHeading;
    private String hobbiesHeading;
    private Person person;
    private Education education;
    private List<String> skills;
    private List<String> accomplishments;
    private List<JobWork> jobWork;
    //    private List<VolunteerWork> volunteerWork;
    private List<Project> projects;
    private List<String> hobbies;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Person {
        /**
         * name : Bob
         * email : johndoe@gmail.com
         * address : 7 Java Drive, OOP City
         * phoneNumber : +1(334)567-2346
         * jobTitle : Software Engineer
         * website : https://www.google.com
         * objective : Bleh bleh bleh bleh bleh bleh bleh bleh
         */

        private String name;
        private String email;
        private String address;
        private String phoneNumber;
        private String jobTitle;
        private String website;
        private String objective;


    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Education {
        private List<School> schools;
//        private List<Examination> examinations;


        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class School {
            /**
             * name : Ardenne High School
             * startDate : 100AD
             * endDate : 104AD
             * summary : Some summary!
             * gpa : 5.0
             */

            private String name;
            private String startDate;
            private String endDate;
            private String summary;
            private String gpa;

        }

//        @Data
//        @JsonIgnoreProperties(ignoreUnknown = true)
//        public static class Examination {
//            /**
//             * name : CSEC
//             * startDate : 104AD
//             * subjects : [{"name":"Math","result":"100"},{"name":"English","result":"100"}]
//             */
//
//            private String name;
//            private String startDate;
//            private List<Subjects> subjects;
//
//
//            @Data
//            @JsonIgnoreProperties(ignoreUnknown = true)
//            public static class Subjects {
//                /**
//                 * name : Math
//                 * result : 100
//                 */
//
//                private String name;
//                private String result;
//
//
//            }
//        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JobWork {
        /**
         * company : Example Ltd.
         * position : Software Engineer
         * summary : At Example Ltd., I did such and such and such and such and such and such and such and such and such.
         * startDate : August 19, 1997
         * endDate : August 19, 2001
         * highlights : ["Worked on such and such","I did such and such and such and such and such and such and such and such and such. I did such and such and such and such and such and such and such and such and such.","Also worked on this"]
         * keywords : ["java","c++"]
         */

        private String company;
        private String position;
        private String summary;
        private String startDate;
        private String endDate;
        private List<String> highlights;
        private List<String> keywords;


    }

//    @Data
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public static class VolunteerWork {
//        /**
//         * company : Example Institution
//         * position : Volunteer
//         * summary : At Example Institution, I did such and such.
//         * startDate : August 19, 1997
//         * endDate : August 19, 2001
//         * highlights : ["Worked on such and such","Also worked on this"]
//         * keywords : ["java","c++"]
//         */
//
//        private String company;
//        private String position;
//        private String summary;
//        private String startDate;
//        private String endDate;
//        private List<String> highlights;
//        private List<String> keywords;
//
//
//    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Project {
        /**
         * name : AwesomeProject
         * description : This awesome project is awesome!
         * highlights : ["Does such and such.","And it does such and such."]
         * keywords : ["java","c++"]
         * url : https://www.github.com
         */

        private String name;
        private String description;
        private String url;
        private List<String> highlights;
        private List<String> keywords;


    }
}

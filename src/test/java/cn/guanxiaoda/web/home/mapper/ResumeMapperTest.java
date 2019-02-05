package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.BaseTest;
import cn.guanxiaoda.web.home.model.Resume;
import cn.guanxiaoda.web.home.model.Resume.Education;
import cn.guanxiaoda.web.home.model.Resume.Person;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
public class ResumeMapperTest extends BaseTest {

    @Autowired MongoResumeMapper mapper;

    @Test
    public void createTest() {
        Resume resume = new Resume();
        resume.setName("guanxiaoda");
        resume.setSkillsHeading("skills");
        resume.setJobWorkHeading("work");
        resume.setAccomplishmentsHeading("hehe");
        resume.setProjectsHeading("aaaaa");
        resume.setHobbiesHeading("bbbb");
        Person person = new Person();
        person.setName("关晓炟");
        person.setEmail("xiaodaguan@gmail.com");
        person.setAddress("addr");
        person.setPhoneNumber("134");
        person.setJobTitle("RD");
        person.setWebsite("guanxiaoda.cn");
        person.setObjective("hmmm");


        resume.setPerson(person);
        resume.setEducation(new Education());
        resume.setSkills(Lists.newArrayList());
        resume.setAccomplishments(Lists.newArrayList());
        resume.setJobWork(Lists.newArrayList());
        resume.setProjects(Lists.newArrayList());
        resume.setHobbies(Lists.newArrayList());

        if (mapper.create(resume)) {
            System.out.println("ok.");
        } else {
            System.out.println("failed.");
        }
    }

    @Test
    public void readTest() {
        Resume resume = mapper.read("guanxiaoda");
        System.out.println(resume);
    }
}

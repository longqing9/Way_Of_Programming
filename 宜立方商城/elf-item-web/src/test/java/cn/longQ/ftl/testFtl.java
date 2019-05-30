package cn.longQ.ftl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class testFtl {
	
	@Test
	public void genFile() throws Exception {
		//创建Freemaker模板
		// 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 第二步：设置模板文件所在的路径。
		configuration.setDirectoryForTemplateLoading(new File("F:\\Program\\Javaproject\\Elf1\\elf-item-web\\src\\main\\webapp\\WEB-INF\\ftl"));
		// 第三步：设置模板文件使用的字符集。一般就是utf-8.
		configuration.setDefaultEncoding("utf-8");
		// 第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("stu.ftl");
		// 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
		Map<String, List> dataModel = new HashMap<>();
		List<Student> list = new ArrayList<>();
		Student stu = new Student("1471", "张三", 18);
		Student stu1 = new Student("5351", "张三", 18);
		Student stu2 = new Student("351", "张三", 18);
		Student stu3 = new Student("361", "张三", 18);
		Student stu4 = new Student("1356", "张三", 18);
		Student stu5 = new Student("351", "张三", 18);
		Student stu6 = new Student("153", "张三", 18);
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu3);
		list.add(stu4);
		list.add(stu6);
		
		//向数据集中添加数据
		dataModel.put("stulist", list);
		
		
		
		// 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
		Writer out = new FileWriter(new File("F:\\Program\\Javaproject\\text\\student.html"));
		// 第七步：调用模板对象的process方法输出文件。
		template.process(dataModel, out);
		// 第八步：关闭流。
		out.close();
	}

	


}

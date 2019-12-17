package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

public class Test
{
public static void main(String[] args) 
{
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
		MetadataSources mds=new MetadataSources(registry);
		Metadata md=mds.getMetadataBuilder().build();
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		
		// set the data in student object stu
		
		Student stu=new Student();
				stu.setRollno(8);
				stu.setName("anku4");
				stu.setAddr("pune4");
				session.save(stu);
				
				session.beginTransaction().commit();
				//Load Example
				Student stu1=session.load(Student.class, 3);
				System.out.println(stu1.getRollno());
				System.out.println(stu1.getName());
				System.out.println(stu1.getAddr());
				
				//Get Example
				Student stu2=session.get(Student.class, 5);
				System.out.println(stu2.getRollno());
				System.out.println(stu2.getName());
				System.out.println(stu2.getAddr());
		
}
	

}

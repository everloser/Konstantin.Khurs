package homework14;


public class People
	{
		private long id;
        private String name;
        private String surname;
        private long age;
  // Вручную правил геттер-сеттер, т.к. jackson автоматом убирает is из булеана
        private boolean isDegree;
		public long getId()
			{
				return id;
			}
		public void setId(long id)
			{
				this.id = id;
			}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public String getSurname()
			{
				return surname;
			}
		public void setSurname(String surname)
			{
				this.surname = surname;
			}
		public long getAge()
			{
				return age;
			}
		public void setAge(long age)
			{
				this.age = age;
			}
		
		
		public boolean isisDegree()
			{
				return isDegree;
			}
		public void setDegree(boolean isDegree)
			{
				this.isDegree = isDegree;
			}
		@Override
		public String toString()
			{
				return "People [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", isDegree="
						+ isDegree + "]";
			}
	}

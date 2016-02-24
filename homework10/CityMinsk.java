package homework10;

public class CityMinsk extends City
	{
		public CityMinsk()
			{
				Prospect pr = new Prospect();
				pr.setProsp(new String[] {"masherova", "pobeditelej", "nezalezhnosti"});
				this.pr = pr;
				Ulica ul = new Ulica();
				ul.setUli(new String[] {"horuzhej", "kulman", "cetkin"});
				this.ul = ul;
				Ploshca pl = new Ploshca();
				pl.setPlo(new String[] {"banhalor", "peramohi", "kruhlaja"});
				this.pl = pl;
				
			}
	}

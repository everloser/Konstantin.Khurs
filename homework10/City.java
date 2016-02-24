package homework10;

import java.util.Arrays;

public class City
	{

		protected Prospect pr;
		protected Ulica ul;
		protected Ploshca pl;

		class Prospect
			{
				private String[] prosp;

				@Override
				public String toString()
					{
						return Arrays.toString(getProsp());
					}

				public String[] getProsp()
					{
						return prosp;
					}

				public void setProsp(String[] prosp)
					{
						this.prosp = prosp;
					}
			}

		class Ulica
			{
				private String[] uli;

				@Override
				public String toString()
					{
						return Arrays.toString(getUli());
					}

				public String[] getUli()
					{
						return uli;
					}

				public void setUli(String[] uli)
					{
						this.uli = uli;
					}

			}

		class Ploshca
			{
				private String[] plo;

				@Override
				public String toString()
					{
						return Arrays.toString(getPlo());
					}

				public String[] getPlo()
					{
						return plo;
					}

				public void setPlo(String[] plo)
					{
						this.plo = plo;
					}

			}

		@Override
		public String toString()
			{
				return "City [проспекты=" + pr.toString() + ", улицы=" + ul.toString() + ", площади=" + pl.toString()
						+ "]";
			}

	}

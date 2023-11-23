package thongTinCountry;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Country 
{
	@Override
	public int hashCode() {
		return Objects.hash(country);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(country, other.country);
	}
	/**
	 * @return the democracy
	 */
	public boolean isDemocracy() {
		return democracy;
	}
	/**
	 * @param democracy the democracy to set
	 */
	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) 
	{
		if(!country.trim().equals(""))
			this.country = country;
		else
			JOptionPane.showMessageDialog(null,"Lỗi chuỗi ở Country");
	}
	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) 
	{
		if(!capital.trim().equals(""))
			this.capital = capital;
		else
			JOptionPane.showMessageDialog(null,"Lỗi chuỗi ở Capital");
	}
	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}
	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) 
	{
		if(population>0)
			this.population = population;
		else
			this.population=0;
	}
	public String xuatDemo()
	{
		if(democracy==true)
		{
			return "V";
			
		}
		else
			return "";
	}
	private String country, capital;
	private int population;
	private boolean democracy;
	public Country(String country, String capital, int population, boolean democracy) 
	{
		setCapital(capital);
		setCountry(country);
		setDemocracy(democracy);
		setPopulation(population);
	}
	public String toString()
	{
		return country+";"+capital+";"+population+";"+xuatDemo();
	}
}

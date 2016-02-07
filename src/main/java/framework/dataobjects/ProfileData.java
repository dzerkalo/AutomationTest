package framework.dataobjects;

import framework.utils.enums.TimeZone;

public final class ProfileData {
	private final String firstName;
	private final String lastName;
	private final String companyName;
	private final String website;
	private final String title;
	private final String phone;
	private final TimeZone timeZone;
	private final int itemsPerPage;
	private final int maxFileAge;


	private ProfileData(final Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		companyName = builder.companyName;
		website = builder.website;
		title = builder.title;
		phone = builder.phone;
		timeZone = builder.timeZone;
		itemsPerPage = builder.itemsPerPage;
		maxFileAge = builder.maxFileAge;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getWebsite() {
		return website;
	}

	public String getTitle() {
		return title;
	}

	public String getPhone() {
		return phone;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public int getMaxFileAge() {
		return maxFileAge;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProfileData that = (ProfileData) o;

		if (itemsPerPage != that.itemsPerPage) return false;
		if (maxFileAge != that.maxFileAge) return false;
		if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
		if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
		if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
		if (website != null ? !website.equals(that.website) : that.website != null) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
		return timeZone == that.timeZone;
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
		result = 31 * result + (website != null ? website.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
		result = 31 * result + itemsPerPage;
		result = 31 * result + maxFileAge;
		return result;
	}

	@Override
	public String toString() {
		return "ProfileData{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", companyName='" + companyName + '\'' +
				", website='" + website + '\'' +
				", title='" + title + '\'' +
				", phone='" + phone + '\'' +
				", timeZone=" + timeZone +
				", itemsPerPage=" + itemsPerPage +
				", maxFileAge=" + maxFileAge +
				'}';
	}

	public static class Builder {
		private String firstName;
		private String lastName;
		private String companyName;
		private String website;
		private String title;
		private String phone;
		private TimeZone timeZone;
		private int itemsPerPage;
		private int maxFileAge;

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;

			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;

			return this;
		}

		public Builder setCompanyName(String companyName) {
			this.companyName = companyName;

			return this;
		}

		public Builder setWebsite(String website) {
			this.website = website;

			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;

			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;

			return this;
		}

		public Builder setTimeZone(TimeZone timeZone) {
			this.timeZone = timeZone;

			return this;
		}

		public Builder setItemsPerPage(int itemsPerPage) {
			this.itemsPerPage = itemsPerPage;

			return this;
		}

		public Builder setMaxFileAge(int maxFileAge) {
			this.maxFileAge = maxFileAge;

			return this;
		}

		public ProfileData build() {
			return new ProfileData(this);
		}
	}
}

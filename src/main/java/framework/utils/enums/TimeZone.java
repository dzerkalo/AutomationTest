package framework.utils.enums;

public enum TimeZone {
	EUROPE_KIEV("Europe/Kiev"),

	AFRICA_ABIDJAN("Africa/Abidjan"),

	UTC("UTC");

	private String timeZone;

	TimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getTimeZoneName() {
		return timeZone;
	}

	public static TimeZone getTimeZoneByName(String name) {
		for (TimeZone timeZone : TimeZone.values()) {
			if (timeZone.getTimeZoneName().equalsIgnoreCase(name)) {
				return timeZone;
			}
		}

		throw new EnumConstantNotPresentException(Enum.class, name);
	}
}

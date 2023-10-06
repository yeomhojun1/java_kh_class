package kh.lclass.db1.opendata.model.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AirVo {
	private String stationName;
	private String datetime;
	private String khaiValue;
	private String pm10Value;
	private String so2Value;
	private String coValue;
	private String no2Value;
	private String o3Value;
}

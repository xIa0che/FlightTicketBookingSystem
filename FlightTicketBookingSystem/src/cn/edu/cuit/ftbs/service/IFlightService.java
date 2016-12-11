package cn.edu.cuit.ftbs.service;

import java.util.Date;
import java.util.List;

import cn.edu.cuit.ftbs.entity.Flight;

/**
 * 航班业务逻辑层接口,<br>
 * 包括对航班信息的增删改查
 * @author xIa0che
 *
 */
public interface IFlightService {

	/**
	 * 增加航班信息
	 * @param flight 要增加的航班实体类对象引用
	 * @return 增加成功返回true，否则返回false
	 */
	public boolean addFlight(Flight flight);

	/**
	 * 删除航班信息
	 * @param flightNum 要删除的航班的航班号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteFlight(String flightNum);

	/**
	 * 更新航班信息
	 * @param flight 要更新的航班实体类对象
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateFlight(Flight flight);

	/**
	 * 按照条件查找航班
	 * @param departureCity 出发城市
	 * @param arrivalCity 到达城市
	 * @param departureTime 出发时间
	 * @return 返回符合条件的航班列表，没有符合条件的航班则返回null
	 */
	public List<Flight> queryFlight(String departureCity,
			String arrivalCity, Date departureTime);

	/**
	 * 根据id查找航班
	 * @param id 要查找的航班id
	 * @return 查找成功返回对应id的航班对象，查找失败返回null
	 */
	public Flight queryFlight(String id);

	/**
	 * 根据航空公司查找航班
	 * @param airline 航空公司名称
	 * @return 返回符合条件的航班列表，没有符合条件的航班则返回null
	 */
	public List<Flight> queryFlightByAirline(String airline);
}

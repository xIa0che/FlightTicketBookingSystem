package cn.edu.cuit.ftbs.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.edu.cuit.ftbs.entity.Flight;

/**
 * Flight数据访问类接口
 * @author xIa0che
 */
public interface IFlightDao {

	/**
	 * 增加航班信息
	 * @param flight 航班实体类对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doCreate(Flight flight) throws SQLException;

	/**
	 * 根据航班id更新航班信息
	 * @param flight 航班实体类对象
	 * @return 如果修改成功返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doUpdate(Flight flight) throws SQLException;

	/**
	 *删除航班信息
	 * @param id 要删除的航班id
	 * @return 如果删除成功返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doRemove(String id) throws SQLException;

	/**
	 * 按照出发城市，到达城市，出发时间查询航班
	 * @param departureCity 出发城市
	 * @param arrivalCity 到达城市
	 * @param departureTime 出发时间
	 * @return 返回符合条件的航班列表，没有满足条件的航班返回null
	 * @throws SQLException 数据库异常
	 */
	public List<Flight> findByCondition(String departureCity,
			String arrivalCity, Date departureTime) throws SQLException;


	/**
	 * 按照出发城市，到达城市，出发时间，航空公司查询航班
	 * @param departureCity 出发城市
	 * @param arrivalCity 到达城市
	 * @param departureTime 出发时间
	 * @param airline 航空公司
	 * @return 返回符合条件的航班列表，没有满足条件的航班返回null
	 * @throws SQLException 数据库异常
	 */
	public List<Flight> findByCondition(String departureCity,
			String arrivalCity, Date departureTime, String airline) throws SQLException;

	/**
	 * 按照id查找航班
	 * @param id 要查找的航班id
	 * @return 航班不存在返回null，否则返回航班实体类对象引用
	 * @throws SQLException 数据库异常
	 */
	public Flight findById(String id) throws SQLException;

	/**
	 * 按照航空公司查找航班
	 * @param airline 要搜索的航空公司名称
	 * @return 返回该航空公司的航班列表
	 * @throws SQLException 数据库异常
	 */
	public List<Flight> findByAirline(String airline) throws SQLException;
}

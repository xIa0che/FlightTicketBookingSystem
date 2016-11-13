package cn.edu.cuit.ftbs.dao;

import cn.edu.cuit.ftbs.entity.Cabin;

public interface ICabinDao {
	public boolean doCreate(Cabin cabin);

	public boolean doUpdate(Cabin cabin);

	public boolean doRemove(Cabin cabin);
}

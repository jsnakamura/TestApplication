package service;

import java.util.List;

import entity.Bus;

public interface BusService {

	public List<Bus> filterByName(String name, List<Bus> busses);

	public boolean createNewBus(int id, String code, String name, List<Bus> busses);

	public Bus getBusById(int id, List<Bus> busses);

	public Bus getBusByCode(String code, List<Bus> busses);

	public Bus getBusByName(String name, List<Bus> busses);

	public boolean updateBusById(Bus bus, List<Bus> busses);
	
	public boolean updateBusByCode(Bus bus, List<Bus> busses);
	
	public boolean updateBusByName(Bus bus, List<Bus> busses);

	public boolean deleteBusById(int id, List<Bus> busses);

	public boolean deleteBusByCode(String code, List<Bus> busses);

	public boolean deleteBusByName(String name, List<Bus> busses);
}

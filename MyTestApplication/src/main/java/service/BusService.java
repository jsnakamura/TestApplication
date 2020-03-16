package service;

import java.util.List;

import entity.Bus;

public interface BusService {

	public List<Bus> filterByName(String name, List<Bus> busses);

	public List<Bus> createNewBus(int id, int code, String name, List<Bus> busses);

	public Bus getBusById(int id, List<Bus> busses);

	public Bus getBusByCode(int code, List<Bus> busses);

	public Bus getBusByName(String name, List<Bus> busses);

	public void updateBus(Bus bus, List<Bus> busses);

	public void deleteBusById(int id, List<Bus> busses);

	public void deleteBusByCode(int code, List<Bus> busses);

	public void deleteBusByName(String name, List<Bus> busses);
}

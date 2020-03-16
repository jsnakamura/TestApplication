package service;

import java.util.List;
import java.util.stream.Collectors;

import entity.Bus;

public class BusServiceImp implements BusService {

	@Override
	public List<Bus> filterByName(String name, List<Bus> busses) {

		return busses.stream().filter(bus -> bus.getNome().contains(name)).collect(Collectors.toList());
	}

	@Override
	public List<Bus> createNewBus(int id, int code, String name, List<Bus> busses) {

		busses.add(new Bus(id, code, name));

		return busses;

	}

	@Override
	public Bus getBusById(int id, List<Bus> busses) {

		return busses.stream().filter(bus -> bus.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Bus getBusByCode(int code, List<Bus> busses) {

		return busses.stream().filter(bus -> bus.getCodigo() == code).findFirst().orElse(null);
	}

	@Override
	public Bus getBusByName(String name, List<Bus> busses) {

		return busses.stream().filter(bus -> bus.getNome() == name).findFirst().orElse(null);
	}

	@Override
	public void updateBus(Bus bus, List<Bus> busses) {

		busses.set(
				busses.indexOf(
						busses.stream().filter(streamBus -> streamBus.getId() == bus.getId()).findFirst().orElse(null)),
				bus);
	}

	@Override
	public void deleteBusById(int id, List<Bus> busses) {

		busses.stream().filter(bus -> bus.getId() == id).forEach(bus -> busses.remove(bus));
	}

	@Override
	public void deleteBusByCode(int code, List<Bus> busses) {

		busses.stream().filter(bus -> bus.getCodigo() == code).forEach(bus -> busses.remove(bus));

	}

	@Override
	public void deleteBusByName(String name, List<Bus> busses) {

		busses.stream().filter(bus -> bus.getNome() == name).forEach(bus -> busses.remove(bus));

	}
}

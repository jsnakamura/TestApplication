package services;

import java.util.List;
import java.util.stream.Collectors;

import entities.Bus;

public class BusServiceImp implements BusService {

	@Override
	public List<Bus> filterByName(String name, List<Bus> busses) {

		return busses.stream().filter(streamBus -> streamBus.getNome().contains(name)).collect(Collectors.toList());
	}

	@Override
	public boolean createNewBus(int id, String code, String name, List<Bus> busses) {

		return busses.stream().filter(streamBus -> streamBus.getId() == id).findFirst().orElse(null) == null
				? busses.add(new Bus(id, code, name))
				: false;
	}

	@Override
	public Bus getBusById(int id, List<Bus> busses) {

		if (busses.isEmpty())
			return null;

		Bus newBus = busses.stream().filter(streamBus -> streamBus.getId() == id).findFirst().orElse(null);

		return newBus != null ? new Bus(newBus.getId(), newBus.getCodigo(), newBus.getNome()) : null;
	}

	@Override
	public Bus getBusByCode(String code, List<Bus> busses) {

		if (busses.isEmpty())
			return null;

		Bus newBus = busses.stream().filter(streamBus -> streamBus.getCodigo().equals(code)).findFirst().orElse(null);

		return newBus != null ? new Bus(newBus.getId(), newBus.getCodigo(), newBus.getNome()) : null;
	}

	@Override
	public Bus getBusByName(String name, List<Bus> busses) {

		if (busses.isEmpty())
			return null;

		Bus newBus = busses.stream().filter(streamBus -> streamBus.getNome().equals(name)).findFirst().orElse(null);

		return newBus != null ? new Bus(newBus.getId(), newBus.getCodigo(), newBus.getNome()) : null;
	}

	@Override
	public boolean updateBusById(Bus bus, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus updatedBus = busses.stream().filter(streamBus -> streamBus.getId() == bus.getId()).findFirst().orElse(null);

		if (updatedBus != null) {
			busses.set(busses.indexOf(updatedBus), new Bus(bus.getId(), bus.getCodigo(), bus.getNome()));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBusByCode(Bus bus, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus updatedBus = busses.stream().filter(streamBus -> streamBus.getCodigo() == bus.getCodigo()).findFirst()
				.orElse(null);

		if (updatedBus != null) {
			busses.set(busses.indexOf(updatedBus),  new Bus(bus.getId(), bus.getCodigo(), bus.getNome()));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBusByName(Bus bus, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus updatedBus = busses.stream().filter(streamBus -> streamBus.getNome() == bus.getNome()).findFirst()
				.orElse(null);

		if (updatedBus != null) {
			busses.set(busses.indexOf(updatedBus),  new Bus(bus.getId(), bus.getCodigo(), bus.getNome()));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteBusById(int id, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus deletedBus = busses.stream().filter(streamBus -> streamBus.getId() == id).findFirst().orElse(null);

		return deletedBus != null ? busses.remove(deletedBus) : false;
	}

	@Override
	public boolean deleteBusByCode(String code, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus deletedBus = busses.stream().filter(streamBus -> streamBus.getCodigo().equals(code)).findFirst()
				.orElse(null);

		return deletedBus != null ? busses.remove(deletedBus) : false;
	}

	@Override
	public boolean deleteBusByName(String name, List<Bus> busses) {

		if (busses.isEmpty())
			return false;

		Bus deletedBus = busses.stream().filter(streamBus -> streamBus.getNome() == name).findFirst().orElse(null);

		return deletedBus != null ? busses.remove(deletedBus) : false;

	}
}

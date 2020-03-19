package services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Bus;
import services.BusService;
import services.BusServiceImp;

class BusServiceTest {

	BusService busService;
	List<Bus> busses;

	@BeforeEach
	void init() {
		busService = new BusServiceImp();
		busses = new ArrayList<Bus>();

		busses.add(new Bus(111, "654", "Joao"));
		busses.add(new Bus(112, "987", "Maria"));
		busses.add(new Bus(121, "321", "Jose"));
		busses.add(new Bus(211, "123", "Julian"));
		busses.add(new Bus(222, "456", "Lacerda"));
		busses.add(new Bus(221, "789", "Mujica"));
		busses.add(new Bus(212, "147", "Galeano"));
		busses.add(new Bus(122, "258", "Arthur"));
	}

	@Test
	void returnListFilteredByName() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, "654", "Joao"), new Bus(121, "321", "Jose"));

		// WHEN
		List<Bus> actual = busService.filterByName("Jo", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void aListNowHasNewElement() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, "654", "Joao"), new Bus(112, "987", "Maria"),
				new Bus(121, "321", "Jose"), new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"),
				new Bus(221, "789", "Mujica"), new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"),
				new Bus(333, "963", "Cris"));

		// WHEN
		busService.createNewBus(333,"963", "Cris", busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void voidListNowAddOneElement() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, "654", "Joao"));
		List<Bus> actual = new ArrayList<>();

		// WHEN
		busService.createNewBus(111, "654", "Joao", actual);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueAfterAddingElement() {

		// GIVEN
		List<Bus> list1 = new ArrayList<>();
		list1.add(new Bus(111, "654", "Joao"));

		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.createNewBus(333, "963", "Julio", list1);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnBusById() {

		// GIVEN
		Bus expected = new Bus(111, "654", "Joao");
		Bus actual;

		// WHEN
		actual = busService.getBusById(111, busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnNullWhenDontHaveElementById() {

		// WHEN
		Bus actual = busService.getBusById(333, busses);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void returnNullWhenListIsEmptyGetById() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		// WHEN
		Bus actual = busService.getBusById(111, aList);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void getByIdCreatesNewObject() {

		// GIVEN
		Bus unexpected;

		// WHEN
		unexpected = busService.getBusById(111, busses);
		unexpected.setCodigo("555");

		// THEN
		assertNotEquals(unexpected, busService.getBusById(111, busses));
	}

	@Test
	void returnBusByCode() {

		// GIVEN
		Bus expected = new Bus(111, "654", "Joao");
		Bus actual;

		// WHEN
		actual = busService.getBusByCode("654", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnNullWhenDontHaveElementByCode() {

		// WHEN
		Bus actual = busService.getBusByCode("333", busses);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void returnNullWhenListIsEmptyGetByCode() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		// WHEN
		Bus actual = busService.getBusByCode("654", aList);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void getByCodeCreatesNewObject() {

		// GIVEN
		Bus unexpected;

		// WHEN
		unexpected = busService.getBusByCode("654", busses);
		unexpected.setId(999);

		// THEN
		assertNotEquals(unexpected, busService.getBusByCode("654", busses));
	}

	@Test
	void returnBusByName() {

		// GIVEN
		Bus expected = new Bus(111, "654", "Joao");
		Bus actual;

		// WHEN
		actual = busService.getBusByName("Joao", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnNullWhenDontHaveElementByName() {

		// WHEN
		Bus actual = busService.getBusByName("", busses);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void returnNullWhenListIsEmptyGetByName() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		// WHEN
		Bus actual = busService.getBusByName("Maria", aList);

		// THEN
		assertEquals(null, actual);
	}

	@Test
	void getByNameCreatesNewObject() {

		// GIVEN
		Bus unexpected;

		// WHEN
		unexpected = busService.getBusByName("Joao", busses);
		unexpected.setId(999);

		// THEN
		assertNotEquals(unexpected, busService.getBusByName("Joao", busses));
	}

	@Test
	void updateListContentById() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, "111", "Joao"), new Bus(112, "987", "Maria"),
				new Bus(121, "321", "Jose"), new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"),
				new Bus(221, "789", "Mujica"), new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		Bus updatedBus = new Bus(111, "111", "Joao");

		// WHEN
		busService.updateBusById(updatedBus, busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyUpdateById() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusById(new Bus(111, "111", "Joao"), aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElementUpdateById() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusById(new Bus(999, "111", "Teste"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementupdatedById() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.updateBusById(new Bus(111, "111", "Jojo"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void updateListContentByCode() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(741852, "654", "Lalalala"), new Bus(112, "987", "Maria"),
				new Bus(121, "321", "Jose"), new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"),
				new Bus(221, "789", "Mujica"), new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		Bus updatedBus = new Bus(741852, "654", "Lalalala");

		// WHEN
		busService.updateBusByCode(updatedBus, busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyUpdateByCode() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusByCode(new Bus(111, "111", "Joao"), aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElementUpdateByCode() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusByCode(new Bus(111, "999", "Teste"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementupdatedByCode() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.updateBusByCode(new Bus(999, "654", "Jojo"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void updateListContentByName() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(741852, "111", "Joao"), new Bus(112, "987", "Maria"),
				new Bus(121, "321", "Jose"), new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"),
				new Bus(221, "789", "Mujica"), new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		Bus updatedBus = new Bus(741852, "111", "Joao");

		// WHEN
		busService.updateBusByName(updatedBus, busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyUpdateByName() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusByName(new Bus(999, "999", "Joao"), aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElementUpdateByName() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.updateBusByName(new Bus(999, "999", "Teste"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementupdatedByName() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.updateBusByName(new Bus(999, "999", "Joao"), busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void isDeletingElementFromListById() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(112, "987", "Maria"), new Bus(121, "321", "Jose"),
				new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"), new Bus(221, "789", "Mujica"),
				new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		// WHEN
		busService.deleteBusById(111, busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyDeleteById() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusById(111, aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElemenDeletetById() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusById(999, busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementDeletedById() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.deleteBusById(111, busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void isDeletingElementFromListByCode() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(112, "987", "Maria"), new Bus(121, "321", "Jose"),
				new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"), new Bus(221, "789", "Mujica"),
				new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		// WHEN
		busService.deleteBusByCode("654", busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyDeleteByCode() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByCode("111", aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElementDeleteByCode() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByCode("999", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementDeletedByCode() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByCode("654", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void isDeletingElementFromListByName() {

		// GIVEN
		List<Bus> expected = Arrays.asList(new Bus(111, "654", "Joao"), new Bus(121, "321", "Jose"),
				new Bus(211, "123", "Julian"), new Bus(222, "456", "Lacerda"), new Bus(221, "789", "Mujica"),
				new Bus(212, "147", "Galeano"), new Bus(122, "258", "Arthur"));

		// WHEN
		busService.deleteBusByName("Maria", busses);

		// THEN
		assertEquals(expected, busses);
	}

	@Test
	void returnFalseIfListIsEmptyDeleteByName() {

		// GIVEN
		List<Bus> aList = new ArrayList<Bus>();

		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByName("Maria", aList);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnFalseIfNoElementDeleteByName() {

		// GIVEN
		boolean expected = false;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByName("", busses);

		// THEN
		assertEquals(expected, actual);
	}

	@Test
	void returnTrueIfElementDeletedByName() {

		// GIVEN
		boolean expected = true;
		boolean actual;

		// WHEN
		actual = busService.deleteBusByName("Maria", busses);

		// THEN
		assertEquals(expected, actual);
	}
}

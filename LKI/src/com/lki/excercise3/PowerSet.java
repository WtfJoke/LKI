package com.lki.excercise3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Manuel
 */
public class PowerSet {

	private static final int BEGINNING_VALUE = 1;
	private static final int ENDING_VALUE = 5;

	public static void main(String[] args) {
		List<Integer> toTest = new ArrayList<>();
		for (int i = BEGINNING_VALUE; i <= ENDING_VALUE; i++) {
			toTest.add(Integer.valueOf(i));
		}
		List<List<Integer>> powerSet = PowerSet.of(toTest);
		for (List<Integer> list : powerSet) {
			for (Integer item : list) {
				System.out.println(item);
			}
		}
	}

	public static <T> List<List<T>> of(Collection<T> list) {
		List<List<T>> powerSet = new ArrayList<>();
		powerSet.add(new ArrayList<T>()); // add the empty set

		// for every item in the original list
		for (T item : list) {
			List<List<T>> newPowerSet = new ArrayList<>();

			for (List<T> subset : powerSet) {
				// copy all of the current powerset's subsets
				newPowerSet.add(subset);

				// plus the subsets appended with the current item
				List<T> newSubset = new ArrayList<>(subset);
				newSubset.add(item);
				newPowerSet.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			powerSet = newPowerSet;
		}
		return powerSet;
	}
}

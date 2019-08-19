package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

public class M {

	public static void main(String[] args) {
		/***Given***/
		ILprodDao lprodDao = new LprodDaoImpl();

		/***When***/
		List<Map> prodList = lprodDao.getProdList("P101");
		for(Map map : prodList)
			for(Object key : map.keySet()) {
				System.out.println(map.get(key));
			}
		

	}

}

package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;

public interface ILprodDao {

	/**
	* Method : getLprodList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	public List<LprodVO> getLprodList();
	
	/**
	* Method : getLprod
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	public List<Map> getProdList(String lprod_gu);
}

package com.inflearn.oop.single_responsibility_principle_tobe;

import com.inflearn.oop.single_responsibility_principle_common.*;

public class MemberService {
	private MemberRepository memberRepository;
	private ProductRepository productRepository;
	private OrderRequest orderReq;

	public void example(Object id, ProductId prodId) {
		Member mem = memberRepository.findOne(id);
		Product prod = productRepository.findOne(prodId);

		int payAmount = prod.price() * orderReq.getAmount();

		PointCalculator pointCalculator = new PointCalculator(mem.getMembership(), payAmount, prodId.getId());
		int point = pointCalculator.calculate();
	}
}

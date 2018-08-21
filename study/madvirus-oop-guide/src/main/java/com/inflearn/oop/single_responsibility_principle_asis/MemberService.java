package com.inflearn.oop.single_responsibility_principle_asis;

import com.inflearn.oop.single_responsibility_principle_common.*;

import static com.inflearn.oop.single_responsibility_principle_common.MemberShip.GOLD;
import static com.inflearn.oop.single_responsibility_principle_common.MemberShip.SILVER;

public class MemberService {
	private MemberRepository memberRepository;
	private ProductRepository productRepository;
	private OrderRequest orderReq;

	public void example(Object id, Object prodId) {
		Member mem = memberRepository.findOne(id);
		Product prod = productRepository.findOne(prodId);

		int payAmount = prod.price() * orderReq.getAmount();

		double pointRate = 0.01;
		if (mem.getMembership() == GOLD) {
			pointRate = 0.03;
		} else if (mem.getMembership() == SILVER) {
			pointRate = 0.02;
		}

		if (isDoublePointTarget(prod)) {
			pointRate *= 2;
		}

		int point = (int) (payAmount * pointRate);


	}

	private boolean isDoublePointTarget(Product prod) {
		return false;
	}
}

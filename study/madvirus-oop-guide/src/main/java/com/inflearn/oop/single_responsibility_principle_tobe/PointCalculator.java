package com.inflearn.oop.single_responsibility_principle_tobe;

import com.inflearn.oop.single_responsibility_principle_common.MemberShip;

import static com.inflearn.oop.single_responsibility_principle_common.MemberShip.GOLD;
import static com.inflearn.oop.single_responsibility_principle_common.MemberShip.SILVER;

public class PointCalculator {
	private MemberShip membership;
	private int payAmount;
	private String prodId;

	public PointCalculator(MemberShip membership, int payAmount, String prodId) {
		this.membership = membership;
		this.payAmount = payAmount;
		this.prodId = prodId;
	}

	public int calculate() {
		double pointRate = 0.01;
		if (membership == GOLD) {
			pointRate = 0.03;
		} else if (membership == SILVER) {
			pointRate = 0.02;
		}

		if (isDoublePointTarget(prodId)) {
			pointRate *= 2;
		}

		return (int) (payAmount * pointRate);
	}

	private boolean isDoublePointTarget(String prodId) {
		return false;
	}
}
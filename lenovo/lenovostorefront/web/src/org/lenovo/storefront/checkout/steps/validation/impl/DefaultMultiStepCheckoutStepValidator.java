/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package org.lenovo.storefront.checkout.steps.validation.impl;


import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.validation.AbstractCheckoutStepValidator;
import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.validation.ValidationResults;
import de.hybris.platform.commercefacades.order.data.CartData;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public class DefaultMultiStepCheckoutStepValidator extends AbstractCheckoutStepValidator
{
	private static final Logger LOGGER = Logger.getLogger(DefaultMultiStepCheckoutStepValidator.class);

	@Override
	public ValidationResults validateOnEnter(final RedirectAttributes redirectAttributes)
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		if (cartData.getEntries() != null && !cartData.getEntries().isEmpty())
		{
			return getCheckoutFacade().hasShippingItems() ? ValidationResults.SUCCESS
					: ValidationResults.REDIRECT_TO_PICKUP_LOCATION;
		}
		LOGGER.info("Missing, empty or unsupported cart");
		return ValidationResults.FAILED;
	}
}

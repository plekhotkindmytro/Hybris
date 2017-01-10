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
package org.lenovo.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.lenovo.fulfilmentprocess.constants.LenovoFulfilmentProcessConstants;

@SuppressWarnings("PMD")
public class LenovoFulfilmentProcessManager extends GeneratedLenovoFulfilmentProcessManager
{
	public static final LenovoFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (LenovoFulfilmentProcessManager) em.getExtension(LenovoFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}

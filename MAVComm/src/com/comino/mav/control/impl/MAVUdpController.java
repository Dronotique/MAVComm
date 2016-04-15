/*
 * Copyright (c) 2016 by E.Mansfeld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.comino.mav.control.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.mavlink.messages.lquac.msg_rc_channels_override;

import com.comino.mav.comm.udp.MAVUdpCommNIO;
import com.comino.mav.control.IMAVController;
import com.comino.msp.model.segment.Status;


public class MAVUdpController extends MAVController implements IMAVController {


	public MAVUdpController(String peerAddress, int peerPort, int bindPort, boolean isSITL) {
		super();
        this.isSITL = isSITL;
		this.peerAddress = peerAddress;
		System.out.println("UDP Controller loaded");
		comm = MAVUdpCommNIO.getInstance(model, peerAddress,peerPort, bindPort);

	}

	@Override
	public boolean connect() {
        return comm.open();
	}


	@Override
	public boolean isConnected() {
		return comm.isConnected() && model.sys.isStatus(Status.MSP_CONNECTED);
	}


}

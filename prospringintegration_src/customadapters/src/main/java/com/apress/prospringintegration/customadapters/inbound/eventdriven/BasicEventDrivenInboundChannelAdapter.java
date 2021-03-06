/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apress.prospringintegration.customadapters.inbound.eventdriven;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

public class BasicEventDrivenInboundChannelAdapter implements InitializingBean {

    private MessagingTemplate template = new MessagingTemplate();

    private MessageChannel channel;

    public void setChannel(MessageChannel channel) {
        this.channel = channel;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Message<?> msg = MessageBuilder.withPayload("hello, world!").build();
        this.template.send(this.channel, msg);
    }
}

/*
 * Copyright $year - MediaWikiEngine
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.mediawikiengine.actions.basic.tokens;

import com.github.mediawikiengine.actions.ReturnableApiAction;
import com.github.mediawikiengine.actions.WikimediaApiAction;
import org.w3c.dom.NodeList;

public class GetEditToken extends WikimediaApiAction implements ReturnableApiAction
{

    public GetEditToken()
    {

        addParameter("prop", "info");
        addParameter("titles", "GetToken");
        addParameter("intoken", "edit");
    }

    @Override
    public boolean getRequiresReadPermission()
    {

        return true;
    }

    @Override
    public boolean getRequiresWritePermission()
    {

        return true;
    }

    @Override
    public String getActionName()
    {

        return "query";
    }

    public String getResult()
    {

        NodeList pageList = getXmlDocument().getElementsByTagName("page");
        String editToken = pageList.item(0).getAttributes().getNamedItem("edittoken").getNodeValue();

        return editToken;
    }

}

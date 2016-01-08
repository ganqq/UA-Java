 /* Copyright (c) 1996-2015, OPC Foundation. All rights reserved.
   The source code in this file is covered under a dual-license scenario:
     - RCL: for OPC Foundation members in good-standing
     - GPL V2: everybody else
   RCL license terms accompanied with this source code. See http://opcfoundation.org/License/RCL/1.00/
   GNU General Public License as published by the Free Software Foundation;
   version 2 of the License are accompanied with this source code. See http://opcfoundation.org/License/GPLv2
   This source code is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
*/

package org.opcfoundation.ua.core;

import org.opcfoundation.ua.builtintypes.ServiceResponse;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import org.opcfoundation.ua.core.CompositeTestType;
import org.opcfoundation.ua.core.ResponseHeader;


public class TestStackExResponse extends Object implements ServiceResponse {

	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.TestStackExResponse);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.TestStackExResponse_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.TestStackExResponse_Encoding_DefaultXml);
	
    protected ResponseHeader ResponseHeader;
    protected CompositeTestType Output;
    
    public TestStackExResponse() {}
    
    public TestStackExResponse(ResponseHeader ResponseHeader, CompositeTestType Output)
    {
        this.ResponseHeader = ResponseHeader;
        this.Output = Output;
    }
    
    public ResponseHeader getResponseHeader()
    {
        return ResponseHeader;
    }
    
    public void setResponseHeader(ResponseHeader ResponseHeader)
    {
        this.ResponseHeader = ResponseHeader;
    }
    
    public CompositeTestType getOutput()
    {
        return Output;
    }
    
    public void setOutput(CompositeTestType Output)
    {
        this.Output = Output;
    }
    
    /**
      * Deep clone
      *
      * @return cloned TestStackExResponse
      */
    public TestStackExResponse clone()
    {
        TestStackExResponse result = new TestStackExResponse();
        result.ResponseHeader = ResponseHeader==null ? null : ResponseHeader.clone();
        result.Output = Output==null ? null : Output.clone();
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TestStackExResponse other = (TestStackExResponse) obj;
        if (ResponseHeader==null) {
            if (other.ResponseHeader != null) return false;
        } else if (!ResponseHeader.equals(other.ResponseHeader)) return false;
        if (Output==null) {
            if (other.Output != null) return false;
        } else if (!Output.equals(other.Output)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ResponseHeader == null) ? 0 : ResponseHeader.hashCode());
        result = prime * result
                + ((Output == null) ? 0 : Output.hashCode());
        return result;
    }
    


	public ExpandedNodeId getTypeId() {
		return ID;
	}

	public ExpandedNodeId getXmlEncodeId() {
		return XML;
	}

	public ExpandedNodeId getBinaryEncodeId() {
		return BINARY;
	}

	public String toString() {
		return ObjectUtils.printFieldsDeep(this);
	}
	
}
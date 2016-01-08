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

import org.opcfoundation.ua.builtintypes.ServiceRequest;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import java.util.Arrays;
import org.opcfoundation.ua.core.RequestHeader;
import org.opcfoundation.ua.core.WriteValue;


public class WriteRequest extends Object implements ServiceRequest {

	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.WriteRequest);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.WriteRequest_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.WriteRequest_Encoding_DefaultXml);
	
    protected RequestHeader RequestHeader;
    protected WriteValue[] NodesToWrite;
    
    public WriteRequest() {}
    
    public WriteRequest(RequestHeader RequestHeader, WriteValue[] NodesToWrite)
    {
        this.RequestHeader = RequestHeader;
        this.NodesToWrite = NodesToWrite;
    }
    
    public RequestHeader getRequestHeader()
    {
        return RequestHeader;
    }
    
    public void setRequestHeader(RequestHeader RequestHeader)
    {
        this.RequestHeader = RequestHeader;
    }
    
    public WriteValue[] getNodesToWrite()
    {
        return NodesToWrite;
    }
    
    public void setNodesToWrite(WriteValue[] NodesToWrite)
    {
        this.NodesToWrite = NodesToWrite;
    }
    
    /**
      * Deep clone
      *
      * @return cloned WriteRequest
      */
    public WriteRequest clone()
    {
        WriteRequest result = new WriteRequest();
        result.RequestHeader = RequestHeader==null ? null : RequestHeader.clone();
        if (NodesToWrite!=null) {
            result.NodesToWrite = new WriteValue[NodesToWrite.length];
            for (int i=0; i<NodesToWrite.length; i++)
                result.NodesToWrite[i] = NodesToWrite[i].clone();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        WriteRequest other = (WriteRequest) obj;
        if (RequestHeader==null) {
            if (other.RequestHeader != null) return false;
        } else if (!RequestHeader.equals(other.RequestHeader)) return false;
        if (NodesToWrite==null) {
            if (other.NodesToWrite != null) return false;
        } else if (!Arrays.equals(NodesToWrite, other.NodesToWrite)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((RequestHeader == null) ? 0 : RequestHeader.hashCode());
        result = prime * result
                + ((NodesToWrite == null) ? 0 : Arrays.hashCode(NodesToWrite));
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
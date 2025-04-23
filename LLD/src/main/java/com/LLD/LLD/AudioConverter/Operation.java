package com.LLD.LLD.AudioConverter;

import java.util.List;

public interface Operation {
    Audio doOperation(Audio audio, List<Operation> operations, int ind);

    void setOperationData(OperationData operationData);
}

CREATE DATABASE IF NOT EXISTS T80_111;

CREATE TABLE IF NOT EXISTS T80_111.T80_111_test_lp
(
    auto_id   BIGINT       NOT NULL,
    batch_id  VARCHAR(255) NOT NULL,
    sortie_id VARCHAR(255) NOT NULL,
    code1     BIGINT       NOT NULL,
    code2     BIGINT,
    code3     VARCHAR(255),
    code4     VARCHAR(255),
    code5     VARCHAR(255),
    code6     VARCHAR(255),
    code7     VARCHAR(255),
    code8     VARCHAR(255),
    code9     VARCHAR(255),
    code10    VARCHAR(255),
    code11    VARCHAR(255),
    code12    VARCHAR(255),
    code13    VARCHAR(255),
    code14    VARCHAR(255)
) DUPLICATE KEY(auto_id, batch_id, sortie_id, code1)
        DISTRIBUTED BY HASH(auto_id) BUCKETS 10
        PROPERTIES (
            "replication_num" = "1"
        );

INSERT INTO T80_111.T80_111_test_lp (auto_id, batch_id, sortie_id, code1, code2, code3, code4, code5,
                                     code6, code7, code8, code9, code10, code11, code12, code13, code14)
VALUES (1001, 'BATCH-A001', 'SORTIE-001', 101, 201, 'C3-001', 'C4-001', 'C5-001',
        'C6-001', 'C7-001', 'C8-001', 'C9-001', 'C10-001', 'C11-001', 'C12-001', 'C13-001', 'C14-001'),
       (1002, 'BATCH-A001', 'SORTIE-002', 102, 202, 'C3-002', 'C4-002', 'C5-002',
        'C6-002', 'C7-002', 'C8-002', 'C9-002', 'C10-002', 'C11-002', 'C12-002', 'C13-002', 'C14-002'),
       (1003, 'BATCH-A002', 'SORTIE-003', 103, 203, 'C3-003', 'C4-003', 'C5-003',
        'C6-003', 'C7-003', 'C8-003', 'C9-003', 'C10-003', 'C11-003', 'C12-003', 'C13-003', 'C14-003'),
       (1004, 'BATCH-A002', 'SORTIE-004', 104, 204, 'C3-004', 'C4-004', 'C5-004',
        'C6-004', 'C7-004', 'C8-004', 'C9-004', 'C10-004', 'C11-004', 'C12-004', 'C13-004', 'C14-004'),
       (1005, 'BATCH-B001', 'SORTIE-005', 105, 205, 'C3-005', 'C4-005', 'C5-005',
        'C6-005', 'C7-005', 'C8-005', 'C9-005', 'C10-005', 'C11-005', 'C12-005', 'C13-005', 'C14-005'),
       (1006, 'BATCH-B001', 'SORTIE-006', 106, 206, 'C3-006', 'C4-006', 'C5-006',
        'C6-006', 'C7-006', 'C8-006', 'C9-006', 'C10-006', 'C11-006', 'C12-006', 'C13-006', 'C14-006'),
       (1007, 'BATCH-B002', 'SORTIE-007', 107, 207, 'C3-007', 'C4-007', 'C5-007',
        'C6-007', 'C7-007', 'C8-007', 'C9-007', 'C10-007', 'C11-007', 'C12-007', 'C13-007', 'C14-007'),
       (1008, 'BATCH-B002', 'SORTIE-008', 108, 208, 'C3-008', 'C4-008', 'C5-008',
        'C6-008', 'C7-008', 'C8-008', 'C9-008', 'C10-008', 'C11-008', 'C12-008', 'C13-008', 'C14-008'),
       (1009, 'BATCH-C001', 'SORTIE-009', 109, 209, 'C3-009', 'C4-009', 'C5-009',
        'C6-009', 'C7-009', 'C8-009', 'C9-009', 'C10-009', 'C11-009', 'C12-009', 'C13-009', 'C14-009'),
       (1010, 'BATCH-C001', 'SORTIE-010', 110, 210, 'C3-010', 'C4-010', 'C5-010',
        'C6-010', 'C7-010', 'C8-010', 'C9-010', 'C10-010', 'C11-010', 'C12-010', 'C13-010', 'C14-010');

CREATE USER 'wangminan' IDENTIFIED BY 'Lab418Server!';
GRANT ALL ON *.* TO 'wangminan';

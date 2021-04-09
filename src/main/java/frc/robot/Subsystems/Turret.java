package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Turret 
{
    public final static WPI_TalonSRX turret_motor = new WPI_TalonSRX(8);

//    /* Nonzero to block the config until success, zero to skip checking */
//    final int kTimeoutMs = 30;
//
//    /**
//     * If the measured travel has a discontinuity, Note the extremities or
//     * "book ends" of the travel.
//     */
//    final boolean kDiscontinuityPresent = true;
//    final int kBookEnd_0 = 910;		/* 80 deg */
//    final int kBookEnd_1 = 1137;	/* 100 deg */
//
//    public void initQuadrature() {
//        /* get the absolute pulse width position */
//        int pulseWidth = turret_motor.getSensorCollection().getPulseWidthPosition();
//
//        /**
//         * If there is a discontinuity in our measured range, subtract one half
//         * rotation to remove it
//         */
//        if (kDiscontinuityPresent) {
//
//            /* Calculate the center */
//            int newCenter;
//            newCenter = (kBookEnd_0 + kBookEnd_1) / 2;
//            newCenter &= 0xFFF;
//
//            /**
//             * Apply the offset so the discontinuity is in the unused portion of
//             * the sensor
//             */
//            pulseWidth -= newCenter;
//        }
//
//        /**
//         * Mask out the bottom 12 bits to normalize to [0,4095],
//         * or in other words, to stay within [0,360) degrees
//         */
//        pulseWidth = pulseWidth & 0xFFF;
//
//        /* Update Quadrature position */
//        turret_motor.getSensorCollection().setQuadraturePosition(pulseWidth, kTimeoutMs);
//    }
}

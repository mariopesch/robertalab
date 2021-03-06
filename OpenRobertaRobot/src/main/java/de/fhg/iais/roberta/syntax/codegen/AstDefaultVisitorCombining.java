package de.fhg.iais.roberta.syntax.codegen;

import java.util.ArrayList;
import java.util.List;

import de.fhg.iais.roberta.syntax.action.display.ClearDisplayAction;
import de.fhg.iais.roberta.syntax.action.display.ShowPictureAction;
import de.fhg.iais.roberta.syntax.action.display.ShowTextAction;
import de.fhg.iais.roberta.syntax.action.light.LightAction;
import de.fhg.iais.roberta.syntax.action.light.LightStatusAction;
import de.fhg.iais.roberta.syntax.action.motor.DriveAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorDriveStopAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorGetPowerAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorSetPowerAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.motor.TurnAction;
import de.fhg.iais.roberta.syntax.action.sound.PlayFileAction;
import de.fhg.iais.roberta.syntax.action.sound.ToneAction;
import de.fhg.iais.roberta.syntax.action.sound.VolumeAction;
import de.fhg.iais.roberta.syntax.lang.expr.ActionExpr;
import de.fhg.iais.roberta.syntax.lang.expr.Binary;
import de.fhg.iais.roberta.syntax.lang.expr.BoolConst;
import de.fhg.iais.roberta.syntax.lang.expr.ColorConst;
import de.fhg.iais.roberta.syntax.lang.expr.EmptyExpr;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.syntax.lang.expr.ExprList;
import de.fhg.iais.roberta.syntax.lang.expr.MathConst;
import de.fhg.iais.roberta.syntax.lang.expr.NullConst;
import de.fhg.iais.roberta.syntax.lang.expr.NumConst;
import de.fhg.iais.roberta.syntax.lang.expr.SensorExpr;
import de.fhg.iais.roberta.syntax.lang.expr.StringConst;
import de.fhg.iais.roberta.syntax.lang.expr.Unary;
import de.fhg.iais.roberta.syntax.lang.expr.Var;
import de.fhg.iais.roberta.syntax.lang.functions.MathPowerFunct;
import de.fhg.iais.roberta.syntax.lang.stmt.ActionStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.AssignStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.ExprStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.IfStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.RepeatStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.SensorStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.Stmt;
import de.fhg.iais.roberta.syntax.lang.stmt.StmtFlowCon;
import de.fhg.iais.roberta.syntax.lang.stmt.StmtList;
import de.fhg.iais.roberta.syntax.sensor.generic.BrickSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.ColorSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.EncoderSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.GyroSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.InfraredSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TouchSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.UltrasonicSensor;
import de.fhg.iais.roberta.visitor.AstVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorCommunicationVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorDisplayVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorLightVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorMotorVisitor;
import de.fhg.iais.roberta.visitor.actor.AstActorSoundVisitor;
import de.fhg.iais.roberta.visitor.lang.AstLanguageVisitor;
import de.fhg.iais.roberta.visitor.sensor.AstSensorsVisitor;

/**
 * This class is THE default implementation of {@link AstVisitor}. All methods are implemented empty ... and may be overwritten in subclasses
 */
@Deprecated
public abstract class AstDefaultVisitorCombining<V> implements AstLanguageVisitor<V>, AstSensorsVisitor<V>, AstActorCommunicationVisitor<V>,
    AstActorDisplayVisitor<V>, AstActorMotorVisitor<V>, AstActorLightVisitor<V>, AstActorSoundVisitor<V> {
    /**
     * initialize the Java code generator visitor.
     *
     * @param programName name of the program
     * @param brickConfiguration hardware configuration of the brick
     * @param indentation to start with. Will be ince/decr depending on block structure
     */
    AstDefaultVisitorCombining() {
    }

    /**
     * a default result must be supplied
     *
     * @return the default
     */
    abstract public V defaultResult();

    /**
     * the aggregation of results must be supplied
     *
     * @param vs the results
     * @return aggregation of two results
     * @return
     */
    abstract public V combine(V v1, V v2);

    /**
     * the aggregation of results must be supplied
     *
     * @param vs the results
     * @return aggregation of two results
     * @return
     */
    abstract public V combine(V v1, V v2, V v3);

    /**
     * the aggregation of results must be supplied
     *
     * @param vs the results
     * @return aggregation of two results
     * @return
     */
    abstract public V combine(List<V> vs);

    @Override
    public V visitNumConst(NumConst<V> numConst) {
        return defaultResult();
    }

    @Override
    public V visitMathConst(MathConst<V> mathConst) {
        return defaultResult();
    }

    @Override
    public V visitBoolConst(BoolConst<V> boolConst) {
        return defaultResult();
    }

    @Override
    public V visitStringConst(StringConst<V> stringConst) {
        return defaultResult();
    }

    @Override
    public V visitNullConst(NullConst<V> nullConst) {
        return defaultResult();
    }

    @Override
    public V visitColorConst(ColorConst<V> colorConst) {
        return defaultResult();
    }

    @Override
    public V visitVar(Var<V> var) {
        return defaultResult();
    }

    @Override
    public V visitUnary(Unary<V> unary) {
        return unary.getExpr().visit(this);
    }

    @Override
    public V visitBinary(Binary<V> binary) {
        V v1 = binary.getLeft().visit(this);
        V v2 = binary.getRight().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitMathPowerFunct(MathPowerFunct<V> func) {
        return defaultResult();
    }

    @Override
    public V visitActionExpr(ActionExpr<V> actionExpr) {
        return actionExpr.getAction().visit(this);
    }

    @Override
    public V visitSensorExpr(SensorExpr<V> sensorExpr) {
        return sensorExpr.getSens().visit(this);
    }

    @Override
    public V visitEmptyExpr(EmptyExpr<V> emptyExpr) {
        return defaultResult();
    }

    @Override
    public V visitExprList(ExprList<V> exprList) {
        List<V> vs = new ArrayList<>();
        for ( Expr<V> expr : exprList.get() ) {
            vs.add(expr.visit(this));
        }
        return combine(vs);
    }

    @Override
    public V visitActionStmt(ActionStmt<V> actionStmt) {
        return actionStmt.getAction().visit(this);
    }

    @Override
    public V visitAssignStmt(AssignStmt<V> assignStmt) {
        V v1 = assignStmt.getName().visit(this);
        V v2 = assignStmt.getExpr().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitExprStmt(ExprStmt<V> exprStmt) {
        return exprStmt.getExpr().visit(this);
    }

    @Override
    public V visitIfStmt(IfStmt<V> ifStmt) {
        List<V> vs = new ArrayList<>();
        for ( Expr<V> expr : ifStmt.getExpr() ) {
            vs.add(expr.visit(this));
        }
        for ( StmtList<V> stmtl : ifStmt.getThenList() ) {
            vs.add(stmtl.visit(this));
        }
        vs.add(ifStmt.getElseList().visit(this));
        return combine(vs);
    }

    @Override
    public V visitRepeatStmt(RepeatStmt<V> repeatStmt) {
        V v1 = repeatStmt.getExpr().visit(this);
        V v2 = repeatStmt.getList().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitSensorStmt(SensorStmt<V> sensorStmt) {
        return defaultResult();
    }

    @Override
    public V visitStmtFlowCon(StmtFlowCon<V> stmtFlowCon) {
        return defaultResult();
    }

    @Override
    public V visitStmtList(StmtList<V> stmtList) {
        List<V> vs = new ArrayList<>();
        for ( Stmt<V> stmt : stmtList.get() ) {
            vs.add(stmt.visit(this));
        }
        return combine(vs);
    }

    @Override
    public V visitDriveAction(DriveAction<V> driveAction) {
        V v1 = driveAction.getParam().getDuration().getValue().visit(this);
        V v2 = driveAction.getParam().getSpeed().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitTurnAction(TurnAction<V> turnAction) {
        return turnAction.getParam().getDuration().getValue().visit(this);
    }

    @Override
    public V visitLightAction(LightAction<V> lightAction) {
        return defaultResult();
    }

    @Override
    public V visitLightStatusAction(LightStatusAction<V> lightStatusAction) {
        return defaultResult();
    }

    @Override
    public V visitMotorGetPowerAction(MotorGetPowerAction<V> motorGetPowerAction) {
        return defaultResult();
    }

    @Override
    public V visitMotorOnAction(MotorOnAction<V> motorOnAction) {
        V v1 = motorOnAction.getParam().getDuration().getValue().visit(this);
        V v2 = motorOnAction.getParam().getSpeed().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitMotorSetPowerAction(MotorSetPowerAction<V> motorSetPowerAction) {
        return motorSetPowerAction.getPower().visit(this);
    }

    @Override
    public V visitMotorStopAction(MotorStopAction<V> motorStopAction) {
        return defaultResult();
    }

    @Override
    public V visitClearDisplayAction(ClearDisplayAction<V> clearDisplayAction) {
        return defaultResult();
    }

    @Override
    public V visitVolumeAction(VolumeAction<V> volumeAction) {
        return volumeAction.getVolume().visit(this);
    }

    @Override
    public V visitPlayFileAction(PlayFileAction<V> playFileAction) {
        return defaultResult();
    }

    @Override
    public V visitShowPictureAction(ShowPictureAction<V> showPictureAction) {
        V v1 = showPictureAction.getX().visit(this);
        V v2 = showPictureAction.getY().visit(this);
        return combine(v1, v2);
    }

    @Override
    public V visitShowTextAction(ShowTextAction<V> showTextAction) {
        V v1 = showTextAction.getX().visit(this);
        V v2 = showTextAction.getY().visit(this);
        V v3 = showTextAction.getMsg().visit(this);
        return combine(v1, v2, v3);
    }

    @Override
    public V visitMotorDriveStopAction(MotorDriveStopAction<V> stopAction) {
        return defaultResult();
    }

    @Override
    public V visitToneAction(ToneAction<V> toneAction) {
        return defaultResult();
    }

    @Override
    public V visitBrickSensor(BrickSensor<V> brickSensor) {
        return defaultResult();
    }

    @Override
    public V visitColorSensor(ColorSensor<V> colorSensor) {
        return defaultResult();
    }

    @Override
    public V visitEncoderSensor(EncoderSensor<V> encoderSensor) {
        return defaultResult();
    }

    @Override
    public V visitGyroSensor(GyroSensor<V> gyroSensor) {
        return defaultResult();
    }

    @Override
    public V visitInfraredSensor(InfraredSensor<V> infraredSensor) {
        return defaultResult();
    }

    @Override
    public V visitTimerSensor(TimerSensor<V> timerSensor) {
        return defaultResult();
    }

    @Override
    public V visitTouchSensor(TouchSensor<V> touchSensor) {
        return defaultResult();
    }

    @Override
    public V visitUltrasonicSensor(UltrasonicSensor<V> ultrasonicSensor) {
        return defaultResult();
    }

}